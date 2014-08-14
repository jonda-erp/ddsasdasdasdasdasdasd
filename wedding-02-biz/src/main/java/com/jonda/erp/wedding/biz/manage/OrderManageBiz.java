package com.jonda.erp.wedding.biz.manage;

import com.jonda.erp.wedding.domain.wedding.order.Order;

/**
 * Created by rejoady on 2014/8/14.
 */
public interface OrderManageBiz {

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    public Boolean createOrder(Order order);

    /**
     * 修改订单
     *
     * @param order
     * @return
     */
    public Boolean modifyOrder(Order order);



}
