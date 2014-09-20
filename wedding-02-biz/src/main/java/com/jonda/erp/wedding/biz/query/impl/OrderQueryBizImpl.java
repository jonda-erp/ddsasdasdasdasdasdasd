package com.jonda.erp.wedding.biz.query.impl;

import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.biz.query.OrderQueryBiz;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import com.jonda.erp.wedding.service.OrderQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/7/18.
 */
@Component("orderQueryBiz")
public class OrderQueryBizImpl implements OrderQueryBiz {

    private static final Logger logger = LoggerFactory.getLogger(OrderQueryBiz.class);

    @Resource
    private OrderQueryService orderQueryService;

    @Override
    public Page<OrderQueryResult> queryOrder(OrderQueryParam param) {
        return orderQueryService.queryOrder(param);
    }

    @Override
    public OrderQueryResult queryOrderByOrderNo(String orderNo) {
        OrderQueryParam param = new OrderQueryParam();
        param.setOrderNo(orderNo);
        Page<OrderQueryResult> page = orderQueryService.queryOrder(param);
        if (page != null && page.getData() != null && !page.getData().isEmpty()) {
            return page.getData().get(0);
        }
        return new OrderQueryResult();
    }
}
