package com.jonda.rbac.shiro.data;

import java.util.List;
import java.util.Objects;

/**
 * 数据访问规则提供
 *
 * @param <T> 数据主键的类型
 */
public interface DataAccessRuleProvider<T> {

    /**
     * 数据访问规则
     *
     * @return
     */
    public String provide(T target);

}
