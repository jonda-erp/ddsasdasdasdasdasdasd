package com.jonda.erp.wedding.service.impl;

import com.jonda.common.dao.PageQueryDao;
import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.domain.wedding.order.ProductUse;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import com.jonda.erp.wedding.dto.product.ProductUseParam;
import com.jonda.erp.wedding.dto.product.ProductUseResult;
import com.jonda.erp.wedding.service.OrderQueryService;
import com.jonda.erp.wedding.service.ProductUseQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/7/18.
 */
@Transactional
@Service("productUseQueryService")
public class ProductUseQueryServiceImpl implements ProductUseQueryService {

    private static final Logger logger = LoggerFactory.getLogger(ProductUseQueryService.class);

    @Resource
    private PageQueryDao pageQueryDao;

    @Override
    public Page<ProductUseResult> queryProductUse(ProductUseParam param) {
        return pageQueryDao.query("com.jonda.erp.wedding.dao.product.ProductUseQueryDao.queryProductUsePage", param);
    }
}
