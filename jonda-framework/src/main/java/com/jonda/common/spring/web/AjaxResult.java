package com.jonda.common.spring.web;

import java.io.Serializable;

/**
 * Created by rejoady on 2014/7/27.
 */
public class AjaxResult implements Serializable {

    private String statusCode;

    private String message;

    private String navTabId;

    private String rel;

    private String callbackType;

    private String forwardUrl;

    private String confirmMsg;

    public AjaxResult() {
    }

    public AjaxResult(StatusCodeEnum statusCode, String message) {
        this.statusCode = statusCode.getCode();
        this.message = message;
    }

    public AjaxResult(String navTabId, String message) {
        this.statusCode = StatusCodeEnum.SUCCESS.getCode();
        this.navTabId = navTabId;
        this.message = message;
    }

    public AjaxResult(String navTabId, String callbackType, String message) {
        this.statusCode = StatusCodeEnum.SUCCESS.getCode();
        this.navTabId = navTabId;
        this.message = message;
        this.callbackType = callbackType;
    }

    public AjaxResult(StatusCodeEnum statusCode, String callbackType, String message) {
        this.statusCode = statusCode.getCode();
        this.message = message;
        this.callbackType = callbackType;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNavTabId() {
        return navTabId;
    }

    public void setNavTabId(String navTabId) {
        this.navTabId = navTabId;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getCallbackType() {
        return callbackType;
    }

    public void setCallbackType(String callbackType) {
        this.callbackType = callbackType;
    }

    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    public String getConfirmMsg() {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg) {
        this.confirmMsg = confirmMsg;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "statusCode='" + statusCode + '\'' +
                ", message='" + message + '\'' +
                ", navTabId='" + navTabId + '\'' +
                ", rel='" + rel + '\'' +
                ", callbackType='" + callbackType + '\'' +
                ", forwardUrl='" + forwardUrl + '\'' +
                ", confirmMsg='" + confirmMsg + '\'' +
                '}';
    }
}
