package com.jonda.rbac.domain;

import com.jonda.common.domain.BaseDomain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rejoady on 2014/7/21.
 */
public class Permission extends BaseDomain implements Serializable, Comparable<Permission> {
    // 资源编码
    private String code;
    // 资源操作（可能为空）
    private String operation;
    // 资源路径
    private String url;
    // 名称
    private String name;
    // 描述
    private String description;
    // 优先级
    private Long ranks;

    @Override
    public int compareTo(Permission o) {
        if (this.getRanks() == null || o == null || o.getRanks() == null) {
            return 0;
        } else if (this.getRanks().longValue() > o.getRanks().longValue()) {
            return 1;
        } else if (this.getRanks().longValue() < o.getRanks().longValue()) {
            return -1;
        }
        return 0;
    }

    /**
     * 默认无参构造方法
     */
    public Permission() {
    }

    public Permission(String code, String operation, String url, String name, String description, Long ranks) {
        this.code = code;
        this.operation = operation;
        this.url = url;
        this.name = name;
        this.description = description;
        this.ranks = ranks;
        Date now = new Date();
        this.creator = "system";
        this.createTime = now;
        this.modifier = "system";
        this.modifyTime = now;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Long getRanks() {
        return ranks;
    }

    public void setRanks(Long ranks) {
        this.ranks = ranks;
    }
}
