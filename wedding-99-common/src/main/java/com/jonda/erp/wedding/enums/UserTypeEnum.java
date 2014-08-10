package com.jonda.erp.wedding.enums;

/**
 * Created by rejoady on 2014/8/10.
 */
public enum UserTypeEnum implements EnumCode {

    SHEYIN("sheyin","摄影师"),

    SHEXIANG("shexiang","摄像师"),

    HUAZHUANG("huazhuang","化妆师"),



            ;


    private String code;

    private String message;

    UserTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
