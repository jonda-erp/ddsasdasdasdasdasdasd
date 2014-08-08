package com.jonda.common.dao;

import com.jonda.common.dto.BasePageQueryParam;
import com.jonda.common.dto.Page;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by rejoady on 2014/7/26.
 */
public class PageQueryDao extends SqlSessionDaoSupport {

    private Logger logger = LoggerFactory.getLogger(PageQueryDao.class);

    /**
     * 查询分页数据
     *
     * @param sql
     * @param param
     * @param <T>
     * @return
     */
    public <T> Page<T> query(String sql, BasePageQueryParam param) {
        Integer count = getSqlSession().selectOne(sql + "_count", param);

        if (param.getPageNo() == null) {
            param.setPageNo(Page.DEFAULT_PAGE_NO);
        }

        if (param.getPageSize() == null) {
            param.setPageSize(Page.DEFAULT_PAGE_SIZE);
        }

        // 页码小于1，设置页码为1
        if (param.getPageNo() < 1) {
            param.setPageNo(Page.DEFAULT_PAGE_NO);
        }

        Integer pageCount = count / param.getPageSize();
        // 不是整数页， 页数+1
        if (count % param.getPageSize() != 0) {
            pageCount ++;
        }

        // 页码大于总页数，页码设置为总页数
        if (pageCount > 0 && param.getPageNo() > pageCount) {
            param.setPageNo(pageCount);
        }

        Page<T> page = new Page<T>();

        try {
            List<T> list = getSqlSession().selectList(sql, param);
            page.setData(list);
            page.setPageNo(param.getPageNo());
            page.setPageSize(param.getPageSize());
            page.setTotalCount(count);
        } catch (Exception ex) {
            logger.error("分页查询数据发生异常，message:{}", ex.getMessage(), ex);
        } catch (Throwable t) {
            logger.error("分页查询数据发生异常，message:{}", t.getMessage(), t);
        }

        return page;
    }

}
