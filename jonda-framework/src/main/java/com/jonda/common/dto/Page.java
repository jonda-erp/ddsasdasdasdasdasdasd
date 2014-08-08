package com.jonda.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rejoady on 2014/7/26.
 */
public class Page<T> implements Serializable {

    public static final Integer DEFAULT_PAGE_SIZE = 20;

    public static final Integer DEFAULT_PAGE_NO = 1;

    private Integer pageSize = DEFAULT_PAGE_SIZE;

    private Integer pageNo = DEFAULT_PAGE_NO;

    private Integer totalCount;

    private List<T> data;

    public Page() {
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
