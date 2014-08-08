package com.jonda.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rejoady on 2014/7/26.
 */
public class BaseQueryParam implements Serializable {

    private Long id;

    private String creator;

    private Date startCreateTime;

    private Date endCreateTime;

    private String modifier;

    private Date startModifyTime;

    private Date endModifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(Date startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getStartModifyTime() {
        return startModifyTime;
    }

    public void setStartModifyTime(Date startModifyTime) {
        this.startModifyTime = startModifyTime;
    }

    public Date getEndModifyTime() {
        return endModifyTime;
    }

    public void setEndModifyTime(Date endModifyTime) {
        this.endModifyTime = endModifyTime;
    }
}
