package com.jonda.erp.wedding.dto.product;

import com.jonda.common.dto.BaseQueryResult;

import java.util.Date;

/**
 * Created by Administrator on 2014/9/16.
 */
public class ProductResult extends BaseQueryResult {
    private String productId;

    private String productName;

    private String productType;

    private String description;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
