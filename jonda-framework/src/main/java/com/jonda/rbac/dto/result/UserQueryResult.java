package com.jonda.rbac.dto.result;

import com.jonda.common.dto.BaseQueryResult;

/**
 * Created by rejoady on 2014/7/26.
 */
public class UserQueryResult extends BaseQueryResult {

    private String name;

    private String loginName;

    private DepartmentQueryResult department;

    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public DepartmentQueryResult getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentQueryResult department) {
        this.department = department;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
