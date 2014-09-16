package com.jonda.erp.wedding.biz.query;

import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import com.jonda.erp.wedding.dto.product.ProductUseParam;
import com.jonda.erp.wedding.dto.product.ProductUseResult;

/**
 * Created by rejoady on 2014/7/18.
 */
public interface ProductUseQueryBiz {

    public Page<ProductUseResult> queryProductUse(ProductUseParam param);

}
