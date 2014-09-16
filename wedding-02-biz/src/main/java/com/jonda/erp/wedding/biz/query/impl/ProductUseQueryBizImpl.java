package com.jonda.erp.wedding.biz.query.impl;

import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.biz.query.ProductUseQueryBiz;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import com.jonda.erp.wedding.dto.product.ProductUseParam;
import com.jonda.erp.wedding.dto.product.ProductUseResult;
import com.jonda.erp.wedding.service.ProductUseQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/7/18.
 */
@Component("productUseQueryBiz")
public class ProductUseQueryBizImpl implements ProductUseQueryBiz {

    private static final Logger logger = LoggerFactory.getLogger(ProductUseQueryBiz.class);

    @Resource
    private ProductUseQueryService productUseQueryService;

    @Override
    public Page<ProductUseResult> queryProductUse(ProductUseParam param) {
        return productUseQueryService.queryProductUse(param);
    }
}
