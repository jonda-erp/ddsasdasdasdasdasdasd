package com.jonda.erp.wedding.service;

import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.dto.product.ProductUseParam;
import com.jonda.erp.wedding.dto.product.ProductUseResult;

/**
 * Created by rejoady on 2014/7/18.
 */
public interface ProductUseQueryService {

    public Page<ProductUseResult> queryProductUse(ProductUseParam param);

}
