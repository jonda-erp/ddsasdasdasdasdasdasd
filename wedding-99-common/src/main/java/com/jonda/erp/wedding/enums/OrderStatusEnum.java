package com.jonda.erp.wedding.enums;

/**
 * Created by rejoady on 2014/8/8.
 */
public enum OrderStatusEnum implements EnumCode {

    INIT("1","初始"),



    ;


    private String code;

    private String message;

    OrderStatusEnum(String code, String message) {
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
