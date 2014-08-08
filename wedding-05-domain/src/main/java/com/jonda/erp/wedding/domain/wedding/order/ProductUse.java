package com.jonda.erp.wedding.domain.wedding.order;

import com.jonda.common.domain.BaseDomain;
import com.jonda.erp.wedding.domain.wedding.Product;

/**
 * 道具使用
 *
 * Created by rejoady on 2014/8/6.
 */
public class ProductUse extends BaseDomain {
    // 对应的合同
    private Contract contract;
    // 道具
    private Product product;
    // 使用数量
    private Integer count;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
