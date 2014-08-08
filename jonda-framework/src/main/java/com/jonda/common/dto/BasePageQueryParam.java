package com.jonda.common.dto;

/**
 * Created by rejoady on 2014/7/26.
 */
public class BasePageQueryParam extends BaseQueryParam {

    private Integer pageSize = Page.DEFAULT_PAGE_SIZE;

    private Integer pageNo = Page.DEFAULT_PAGE_NO;

    private Integer start;

    private Integer limit;

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

    public Integer getStart() {
        return this.pageSize * (this.pageNo - 1);
    }

    public Integer getLimit() {
        return this.pageSize;
    }
}
