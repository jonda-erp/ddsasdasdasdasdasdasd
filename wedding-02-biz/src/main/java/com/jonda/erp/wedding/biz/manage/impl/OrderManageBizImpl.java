package com.jonda.erp.wedding.biz.manage.impl;

import com.jonda.erp.wedding.biz.manage.OrderManageBiz;
import com.jonda.erp.wedding.domain.wedding.order.Order;
import com.jonda.erp.wedding.service.OrderManageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/8/14.
 */
@Component("orderManageBiz")
public class OrderManageBizImpl implements OrderManageBiz {

    @Resource
    private OrderManageService orderManageService;

    @Override
    public Boolean createOrder(Order order) {
        orderManageService.createOrder(order);
        return Boolean.TRUE;
    }

    @Override
    public Boolean modifyOrder(Order order) {
        return null;
    }
}
