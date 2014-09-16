package com.jonda.erp.wedding.dto.product;

import com.jonda.common.dto.BaseQueryResult;

import java.util.Date;

/**
 * Created by Administrator on 2014/9/16.
 */
public class ProductUseResult extends BaseQueryResult {
    //合同ID
    private String contractId;
    //道具ID
    private int productId;
    // 道具个数
    private int productCount;

    private ProductResult product;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public ProductResult getProduct() {
        return product;
    }

    public void setProduct(ProductResult product) {
        this.product = product;
    }
}
