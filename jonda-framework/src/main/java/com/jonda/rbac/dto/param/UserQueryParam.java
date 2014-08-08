package com.jonda.rbac.dto.param;

import com.jonda.common.dto.BasePageQueryParam;

/**
 * Created by rejoady on 2014/7/26.
 */
public class UserQueryParam extends BasePageQueryParam {

    private String loginName;

    private String name;

    private Long departmentId;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
