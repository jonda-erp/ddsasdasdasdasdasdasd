package com.jonda.common.spring.web;

import com.jonda.common.dto.Page;
import org.springside.modules.mapper.JsonMapper;

import java.io.Serializable;
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
        this.rows = page.getData();
    }

    @Override
    public String toString() {
        JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
        return jsonMapper.toJson(this);
    }

    public static <T extends Serializable> String getJsonResult(Page<T> page) {
        JsonResult<T> jsonResult = new JsonResult<T>(page);
        return jsonResult.toString();
    }

    public Integer getTotal() {
        return total;
    }

    public List<T> getRows() {
        return rows;
    }
}
