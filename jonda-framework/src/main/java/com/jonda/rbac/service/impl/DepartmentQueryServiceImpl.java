package com.jonda.rbac.service.impl;

import com.jonda.rbac.dao.DepartmentQueryDao;
import com.jonda.rbac.dto.result.DepartmentQueryResult;
import com.jonda.rbac.service.DepartmentQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rejoady on 2014/7/27.
 */
@Service("departmentQueryService")
public class DepartmentQueryServiceImpl implements DepartmentQueryService {

    @Resource
    private DepartmentQueryDao departmentQueryDao;

    @Override
    public List<DepartmentQueryResult> getAllDepartment() {
        return departmentQueryDao.getAllDepartment();
    }
}
