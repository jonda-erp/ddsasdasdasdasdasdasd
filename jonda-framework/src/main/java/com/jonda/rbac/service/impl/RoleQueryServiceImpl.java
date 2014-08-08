package com.jonda.rbac.service.impl;

import com.jonda.rbac.dao.RoleQueryDao;
import com.jonda.rbac.dto.result.RoleQueryResult;
import com.jonda.rbac.service.RoleQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rejoady on 2014/7/29.
 */
@Service("roleQueryService")
public class RoleQueryServiceImpl implements RoleQueryService {

    @Resource
    private RoleQueryDao roleQueryDao;

    @Override
    public List<RoleQueryResult> getAllRole() {
        return roleQueryDao.getAllRoles();
    }

    @Override
    public RoleQueryResult getRoleById(Long id) {
        return roleQueryDao.getRoleById(id);
    }

    @Override
    public List<Long> getRoleByUserId(Long userId) {
        return roleQueryDao.getRoleByUserId(userId);
    }
}
