package com.jonda.rbac.dao;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.rbac.dto.result.DepartmentQueryResult;

import java.util.List;

/**
 * Created by rejoady on 2014/7/19.
 */
@MyBatisRepository
public interface DepartmentQueryDao {

    public List<DepartmentQueryResult> getAllDepartment();

}
