package com.jonda.common.spring.web.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jonda.common.dto.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rejoady on 2014/9/11.
 */
public class JsonResult<T extends Serializable> implements Serializable {

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

    public static <T extends Serializable> String getJsonResult(Page<T> page) {
        JsonResult<T> jsonResult = new JsonResult<T>(page);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String json = gson.toJson(jsonResult, JsonResult.class);
        return json;
    }

    public Integer getTotal() {
        return total;
    }

    public List<T> getRows() {
        return rows;
    }
}
