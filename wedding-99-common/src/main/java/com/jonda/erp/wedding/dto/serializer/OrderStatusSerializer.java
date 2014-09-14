package com.jonda.erp.wedding.dto.serializer;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jonda.erp.wedding.enums.OrderStatusEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Created by rejoady on 2014/9/12.
 */
public class OrderStatusSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (StringUtils.isNotBlank(value)) {
            for (OrderStatusEnum e : OrderStatusEnum.values()) {
                if (e.getCode().equals(value.toString())) {
                    gen.writeString(e.getMessage());
                    return;
                }
            }
        }
        gen.writeString("未知");
    }
}
