package com.jonda.erp.wedding.dto.order;

import com.jonda.common.dto.BasePageQueryParam;

import java.util.Date;

/**
 * Created by rejoady on 2014/8/8.
 */
public class OrderQueryParam extends BasePageQueryParam {
    //订单号
    private String orderNo;
    //合同号
    private String contractNo;
    // 姓名(新郎或新娘)
    private String name;
    // 电话(新郎或新娘)
    private String telephone;
    // 婚庆日期
    private Date startWeddingDate;
    // 婚庆日期
    private Date endWeddingDate;
    // 订单状态
    private String status;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getStartWeddingDate() {
        return startWeddingDate;
    }

    public void setStartWeddingDate(Date startWeddingDate) {
        this.startWeddingDate = startWeddingDate;
    }

    public Date getEndWeddingDate() {
        return endWeddingDate;
    }

    public void setEndWeddingDate(Date endWeddingDate) {
        this.endWeddingDate = endWeddingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
