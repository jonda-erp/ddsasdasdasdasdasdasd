package com.jonda.erp.wedding.service;

import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;

/**
 * Created by rejoady on 2014/7/18.
 */
public interface OrderQueryService {

    /**
     * 分页查询订单信息
     *
     * @param param
     * @return
     */
    public Page<OrderQueryResult> queryOrder(OrderQueryParam param);

    /**
     * 根据订单编号查询订单信息
     *
     * @param orderNo
     * @return
     */
    public OrderQueryResult getByOrderNo(String orderNo);

}
