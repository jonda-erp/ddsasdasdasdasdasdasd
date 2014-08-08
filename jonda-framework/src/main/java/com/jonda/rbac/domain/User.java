package com.jonda.rbac.domain;

import com.jonda.common.domain.AccessControlledDomain;

import java.util.List;

/**
 * Created by rejoady on 2014/7/17.
 */
public class User extends AccessControlledDomain {

    private String name;

    private String loginName;

    private String password;

    private String salt;

    private Department department;

    private String remark;

    private List<Role> roles;
    // 用户对于数据权限控制级别的权限所属策略组
    private List<DataStrategyGroup> dataStrategyGroups;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<DataStrategyGroup> getDataStrategyGroups() {
        return dataStrategyGroups;
    }

    public void setDataStrategyGroups(List<DataStrategyGroup> dataStrategyGroups) {
        this.dataStrategyGroups = dataStrategyGroups;
    }
}
