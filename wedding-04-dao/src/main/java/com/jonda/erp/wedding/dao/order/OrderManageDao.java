package com.jonda.erp.wedding.dao.order;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.erp.wedding.domain.wedding.order.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

/**
 * Created by rejoady on 2014/8/15.
 */
@MyBatisRepository
public interface OrderManageDao {

    @Insert("insert into wedding_order" +
            "(order_no,bride_name, bride_telephone, bridegroom_name, bridegroom_telephone, wedding_date, order_status, remark, creator, create_time, modifier, data_status)" +
            "values" +
            "(#{orderNo},#{brideName}, #{brideTelephone}, #{bridegroomName}, #{bridegroomTelephone}, #{weddingDate}, #{status}, #{remark}, #{creator}, SYSDATE(), #{modifier}, 1)")
    public void addOrder(Order order);
}
