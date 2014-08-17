package com.jonda.erp.wedding.dao.order;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.erp.wedding.dto.order.InvoiceQueryResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by rejoady on 2014/8/17.
 */
@MyBatisRepository
public interface InvoiceQueryDao {

    public List<InvoiceQueryResult> getInvoiceByOrderId(Long orderId);

}
