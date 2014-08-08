package com.jonda.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rejoady on 2014/7/17.
 */
public abstract class BaseDomain implements Serializable {

    protected Long id;

    protected String creator;

    protected Date createTime;

    protected String modifier;

    protected Date modifyTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
