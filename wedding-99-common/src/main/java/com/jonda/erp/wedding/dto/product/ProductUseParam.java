package com.jonda.erp.wedding.dto.product;

import com.jonda.common.dto.BasePageQueryParam;

import java.util.Date;

/**
 * Created by rejoady on 2014/8/8.
 */
public class ProductUseParam extends BasePageQueryParam {

    //合同ID
    private String contractId;
    //道具ID
    private int productId;
    // 道具个数
    private int productCount;
    // 创建人
    private String creator;
    // 创建时间
    private Date createTime;
    // 修改人
    private String modifier;
    // 修改时间
    private Date modifyTime;

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
