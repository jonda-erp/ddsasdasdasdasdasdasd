package com.jonda.rbac.dto.result;

import com.jonda.common.dto.BaseQueryResult;

/**
 * Created by rejoady on 2014/7/26.
 */
public class RoleQueryResult extends BaseQueryResult {
    // 名称
    private String name;
    // 角色编码
    private String code;
    // 描述
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
