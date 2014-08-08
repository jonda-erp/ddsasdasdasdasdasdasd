package com.jonda.erp.wedding.domain.wedding.order;

import com.jonda.common.domain.BaseDomain;

/**
 * 人员需求
 *
 * Created by rejoady on 2014/8/6.
 */
public class WorkerRequired extends BaseDomain {
    // 对应合同
    private Contract contract;
    // 人员角色
    private String userRole;
    // 需求数量
    private Integer count;
    // 备注
    private String remark;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
