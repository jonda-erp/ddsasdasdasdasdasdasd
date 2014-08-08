package com.jonda.rbac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rejoady on 2014/7/27.
 */
public enum OperationEnum {

    ACCESS("access","访问"),
    CREATE("create","创建"),
    MODIFY("modify","修改"),
    DELETE("delete","删除"),

            ;

    private String code;

    private String name;

    OperationEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Map<String, String> toMap() {
        OperationEnum[] enums = OperationEnum.values();
        Map<String, String> result = new HashMap<String, String>();
        for (OperationEnum operation : enums) {
            result.put(operation.getCode(), operation.getName());
        }
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
