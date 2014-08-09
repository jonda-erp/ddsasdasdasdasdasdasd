package com.jonda.erp.wedding.service;

import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;

/**
 * Created by rejoady on 2014/7/18.
 */
public interface OrderQueryService {

    public Page<OrderQueryResult> queryOrder(OrderQueryParam param);

}
