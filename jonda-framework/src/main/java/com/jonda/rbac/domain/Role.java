package com.jonda.rbac.domain;

import com.jonda.common.domain.BaseDomain;

import java.util.List;

/**
 * Created by rejoady on 2014/7/17.
 */
public class Role extends BaseDomain {

    private String code;

    private String name;

    private String description;

    private List<Permission> permissions;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
