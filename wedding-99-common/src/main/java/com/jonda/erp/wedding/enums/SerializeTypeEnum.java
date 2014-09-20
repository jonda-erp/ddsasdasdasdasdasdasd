package com.jonda.erp.wedding.enums;

/**
 * Created by rejoady on 2014/9/16.
 */
public enum SerializeTypeEnum implements EnumCode {

    ORDER("O","订单"),

    CONTRACT("C","合同"),
            ;
    private String code;

    private String message;

    private SerializeTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
