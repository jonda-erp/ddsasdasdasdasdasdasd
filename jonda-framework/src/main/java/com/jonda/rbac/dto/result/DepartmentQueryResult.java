package com.jonda.rbac.dto.result;

import com.jonda.common.dto.BaseQueryResult;

import java.util.List;

/**
 * Created by rejoady on 2014/7/26.
 */
public class DepartmentQueryResult extends BaseQueryResult {

    private String name;

    private String description;
    // 上级部门
    private DepartmentQueryResult parent;
    // 子部门
    private List<DepartmentQueryResult> children;

    private Integer left;

    private Integer right;

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

    public DepartmentQueryResult getParent() {
        return parent;
    }

    public void setParent(DepartmentQueryResult parent) {
        this.parent = parent;
    }

    public List<DepartmentQueryResult> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentQueryResult> children) {
        this.children = children;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }
}
