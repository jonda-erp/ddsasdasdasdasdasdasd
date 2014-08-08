package com.jonda.common.domain;

/**
 * 接受数据权限控制的Domain基类
 *
 * Created by rejoady on 2014/7/25.
 */
public abstract class AccessControlledDomain extends BaseDomain {
    // 记录所属的部门
    private Long departmentId;
    // 记录所属的用户
    private Long userId;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
