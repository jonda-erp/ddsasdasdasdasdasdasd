package com.jonda.rbac.domain;

import com.jonda.common.domain.BaseDomain;

import java.util.List;

/**
 * Created by rejoady on 2014/7/17.
 */
public class Department extends BaseDomain {

    private String name;

    private String description;
    // 上级部门
    private Department parent;
    // 子部门
    private List<Department> children;

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

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
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
