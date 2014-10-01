package com.jonda.erp.wedding.dto.invoice;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jonda.common.dto.BaseQueryResult;
import com.jonda.common.spring.web.json.DateSerializer;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import com.jonda.erp.wedding.dto.serializer.InvoiceFundTypeSerializer;

import java.util.Date;

/**
 * Created by rejoady on 2014/8/17.
 */
public class InvoiceQueryResult extends BaseQueryResult {
    // 开票人姓名
    private String userName;
    // 发票类型
    private String type;
    // 金额
    private Integer amount;
    // 摘要
    private String remark;

    // 订单信息
    //订单号
    private String orderNo;
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
    private String orderRemark;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonSerialize(using = InvoiceFundTypeSerializer.class)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }
}
