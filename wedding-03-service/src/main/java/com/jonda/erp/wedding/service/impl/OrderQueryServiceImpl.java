package com.jonda.erp.wedding.service.impl;

import com.jonda.common.dao.PageQueryDao;
import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import com.jonda.erp.wedding.service.OrderQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/7/18.
 */
@Transactional
@Service("orderQueryService")
public class OrderQueryServiceImpl implements OrderQueryService {

    private static final Logger logger = LoggerFactory.getLogger(OrderQueryService.class);

    @Resource
    private PageQueryDao pageQueryDao;

    @Override
    public Page<OrderQueryResult> queryOrder(OrderQueryParam param) {
        return pageQueryDao.query("com.jonda.erp.wedding.dao.order.OrderQueryDao.queryOrderPage", param);
    }
}
