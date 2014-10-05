package com.jonda.erp.wedding.dao.invoice;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.erp.wedding.domain.wedding.order.Invoice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by rejoady on 2014/10/5.
 */
@MyBatisRepository
public interface InvoiceManageDao {

    @Insert("insert into wedding_invoice" +
            "(order_no,invoice_person_id, fund_type, amount, abstract, creator, create_time, modifier, data_status)" +
            "values" +
            "(#{order.orderNo},#{user.id}, #{fundType}, #{amount}, #{remark}, #{creator}, SYSDATE(), #{modifier}, 1)")
    public void addInvoice(Invoice invoice);

    @Update("update wedding_invoice set data_status=0, modifier=#{modifier} where id=#{id}")
    public void delete(Invoice invoice);

}
