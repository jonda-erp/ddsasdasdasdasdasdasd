package com.jonda.common.spring.web;

/**
 * Created by rejoady on 2014/7/27.
 */
public enum StatusCodeEnum {

    SUCCESS("200", "操作成功."),

    ERROR("300", "对不起，系统发生错误，请通知管理员."),

    SESSION_TIME_OUT("301","会话已经过期，请重新登录系统."),
    ;

    private String code;

    private String message;

    StatusCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
