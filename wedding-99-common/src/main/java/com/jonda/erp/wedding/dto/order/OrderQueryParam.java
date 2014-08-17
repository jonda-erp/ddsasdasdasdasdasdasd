package com.jonda.erp.wedding.dto.order;

import com.jonda.common.dto.BasePageQueryParam;

import java.util.Date;

/**
 * Created by rejoady on 2014/8/8.
 */
public class OrderQueryParam extends BasePageQueryParam {

    // 新娘姓名
    private String brideName;
    // 新娘电话
    private String brideTelephone;
    // 新郎姓名
    private String bridegroomName;
    // 新郎电话
    private String bridegroomTelephone;
    // 婚庆日期
    private Date startWeddingDate;
    // 婚庆日期
    private Date endWeddingDate;
    // 订单状态
    private String status;

    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    public String getBrideTelephone() {
        return brideTelephone;
    }

    public void setBrideTelephone(String brideTelephone) {
        this.brideTelephone = brideTelephone;
    }

    public String getBridegroomName() {
        return bridegroomName;
    }

    public void setBridegroomName(String bridegroomName) {
        this.bridegroomName = bridegroomName;
    }

    public String getBridegroomTelephone() {
        return bridegroomTelephone;
    }

    public void setBridegroomTelephone(String bridegroomTelephone) {
        this.bridegroomTelephone = bridegroomTelephone;
    }

    public Date getStartWeddingDate() {
        return startWeddingDate;
    }

    public void setStartWeddingDate(Date startWeddingDate) {
        this.startWeddingDate = startWeddingDate;
    }

    public Date getEndWeddingDate() {
        return endWeddingDate;
    }

    public void setEndWeddingDate(Date endWeddingDate) {
        this.endWeddingDate = endWeddingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
