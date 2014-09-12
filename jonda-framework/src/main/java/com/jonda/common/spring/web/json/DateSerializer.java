package com.jonda.common.spring.web.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by rejoady on 2014/9/12.
 */
public class DateSerializer implements JsonSerializer<Date> {

    @Override
    public JsonElement serialize(java.util.Date src, Type typeOfSrc,
                                 JsonSerializationContext context) {
        String formatDate = DateFormatUtils.format(src, "yyyy-MM-dd");
        return new JsonPrimitive(formatDate);
    }

}
