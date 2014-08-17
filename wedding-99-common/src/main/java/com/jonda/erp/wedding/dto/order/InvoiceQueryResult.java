package com.jonda.erp.wedding.dto.order;

import com.jonda.common.dto.BaseQueryResult;

/**
 * Created by rejoady on 2014/8/17.
 */
public class InvoiceQueryResult extends BaseQueryResult {
    // 订单
    private OrderQueryResult order;
    // 开票人姓名
    private String userName;
    // 发票类型
    private String type;
    // 金额
    private Integer amount;
    // 摘要
    private String remark;

    public OrderQueryResult getOrder() {
        return order;
    }

    public void setOrder(OrderQueryResult order) {
        this.order = order;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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
}
