package com.jonda.erp.wedding.domain.wedding.order;

import com.jonda.common.domain.BaseDomain;
import com.jonda.rbac.domain.User;

/**
 * 发票
 *
 * Created by rejoady on 2014/8/6.
 */
public class Invoice extends BaseDomain {
    // 订单
    private Order order;
    // 开票人
    private User user;
    // 资金类型
    private String fundType;
    // 开票金额
    private String amount;
    // 摘要
    private String remark;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
