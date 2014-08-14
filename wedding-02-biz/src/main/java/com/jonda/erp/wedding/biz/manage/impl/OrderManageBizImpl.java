package com.jonda.erp.wedding.biz.manage.impl;

import com.jonda.erp.wedding.biz.manage.OrderManageBiz;
import com.jonda.erp.wedding.domain.wedding.order.Order;
import org.springframework.stereotype.Component;

/**
 * Created by rejoady on 2014/8/14.
 */
@Component("orderManageBiz")
public class OrderManageBizImpl implements OrderManageBiz {

    @Override
    public Boolean createOrder(Order order) {
        return Boolean.TRUE;
    }

    @Override
    public Boolean modifyOrder(Order order) {
        return null;
    }
}
