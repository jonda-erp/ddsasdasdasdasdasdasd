package com.jonda.erp.wedding.enums;

/**
 * Created by rejoady on 2014/8/10.
 */
public enum ProductTypeEnum implements EnumCode {

    SHEXIANGJI("shexiangji","摄像机"),

    HUA("hua","花"),

    MUBU("mubu","幕布"),



            ;


    private String code;

    private String message;

    ProductTypeEnum(String code, String message) {
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
