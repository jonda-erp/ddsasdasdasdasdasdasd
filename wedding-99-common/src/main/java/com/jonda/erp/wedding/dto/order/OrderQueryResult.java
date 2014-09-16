package com.jonda.erp.wedding.dto.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jonda.common.dto.BaseQueryResult;
import com.jonda.common.spring.web.json.DateSerializer;
import com.jonda.erp.wedding.dto.serializer.OrderStatusSerializer;

import java.util.Date;

/**
 * Created by rejoady on 2014/8/8.
 */
public class OrderQueryResult extends BaseQueryResult {

    //订单号
    private String orderNo;
    //合同号
    private String contractNo;
    // 新娘姓名
    private String brideName;
    // 新娘电话
    private String brideTelephone;
    // 新郎姓名
    private String bridegroomName;
    // 新郎电话
    private String bridegroomTelephone;
    // 婚庆日期

    private Date weddingDate;
    // 订单状态
    private String status;
    // 备注
    private String remark;

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

    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    public String getBrideTelephone() {
        return brideTelephone;
    }

    public void setBrideTelephone(String brideTelephone) {
        this.brideTelephone = brideTelephone;
    }

    public String getBridegroomName() {
        return bridegroomName;
    }

    public void setBridegroomName(String bridegroomName) {
        this.bridegroomName = bridegroomName;
    }

    public String getBridegroomTelephone() {
        return bridegroomTelephone;
    }

    public void setBridegroomTelephone(String bridegroomTelephone) {
        this.bridegroomTelephone = bridegroomTelephone;
    }

    @JsonSerialize(using=DateSerializer.class)
    public Date getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }

    @JsonSerialize(using=OrderStatusSerializer.class)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
