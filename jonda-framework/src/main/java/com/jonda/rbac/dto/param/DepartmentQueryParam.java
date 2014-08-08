package com.jonda.rbac.dto.param;

import com.jonda.common.dto.BaseQueryParam;

/**
 * Created by rejoady on 2014/7/26.
 */
public class DepartmentQueryParam extends BaseQueryParam {

    private String name;

    private String description;

    private Integer parentId;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
