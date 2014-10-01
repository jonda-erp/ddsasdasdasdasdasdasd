package com.jonda.common.spring.web.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.jonda.common.dto.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rejoady on 2014/9/11.
 */
public class JsonResult<T extends Serializable> implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(JsonResult.class);

    private Integer total;

    private List<T> rows;

    private JsonResult(Page<T> page) {
        if (page == null) throw new RuntimeException("参数不正确，分页对象不能为空");
        this.total = page.getTotalCount();
        if (page.getData() == null) {
            this.rows = new ArrayList<T>();
        } else {
            this.rows = page.getData();
        }
    }

    private JsonResult(List<T> list) {
        if (list == null) throw new RuntimeException("参数不正确，分页对象不能为空");
        this.total = list.size();
        if (list == null) {
            this.rows = new ArrayList<T>();
        } else {
            this.rows = list;
        }
    }

    public static <T extends Serializable> String getJsonResult(Page<T> page) {
        ObjectMapper mapper = new ObjectMapper();
        JsonResult<T> jsonResult = new JsonResult<T>(page);
        String json = null;
        try {
            json = mapper.writeValueAsString(jsonResult);
        } catch (JsonProcessingException e) {
            logger.error("将Page对象转成为Json发生异常，message:{}", e.getMessage(),e);
        }
        return json;
    }

    public static <T extends Serializable> String getJsonResult(List<T> list) {
        ObjectMapper mapper = new ObjectMapper();
        JsonResult<T> jsonResult = new JsonResult<T>(list);
        String json = null;
        try {
            json = mapper.writeValueAsString(jsonResult);
        } catch (JsonProcessingException e) {
            logger.error("将List对象转成为Json发生异常，message:{}", e.getMessage(),e);
        }
        return json;
    }

    public Integer getTotal() {
        return total;
    }

    public List<T> getRows() {
        return rows;
    }
}
