package com.jonda.erp.wedding.enums;

/**
 * Created by rejoady on 2014/8/8.
 */
public enum InvoiceFundTypeEnum implements EnumCode {

    FIRST("1","订金"),

    SECOND("2","补款"),

    END("3","尾款"),

    ;


    private String code;

    private String message;

    InvoiceFundTypeEnum(String code, String message) {
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
