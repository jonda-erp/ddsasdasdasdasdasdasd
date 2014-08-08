package com.jonda.rbac.service;

import com.jonda.rbac.dto.result.DepartmentQueryResult;

import java.util.List;

/**
 * Created by rejoady on 2014/7/21.
 */
public interface DepartmentQueryService {

    /**
     * 查询所有的部门列表
     *
     * @return
     */
    public List<DepartmentQueryResult> getAllDepartment();

}
