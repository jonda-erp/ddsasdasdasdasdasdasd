package com.jonda.rbac.dto.result;

import com.jonda.common.dto.BaseQueryResult;

/**
 * Created by rejoady on 2014/7/26.
 */
public class PermissionQueryResult extends BaseQueryResult implements Comparable<PermissionQueryResult>  {
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
    public int compareTo(PermissionQueryResult o) {
        if (this.getRanks() == null || o == null || o.getRanks() == null) {
            return 0;
        } else if (this.getRanks().longValue() > o.getRanks().longValue()) {
            return 1;
        } else if (this.getRanks().longValue() < o.getRanks().longValue()) {
            return -1;
        }
        return 0;
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
