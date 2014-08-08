package com.jonda.rbac.service.impl;

import com.jonda.rbac.dao.PermissionQueryDao;
import com.jonda.rbac.dto.result.PermissionQueryResult;
import com.jonda.rbac.service.PermissionQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rejoady on 2014/7/27.
 */
@Service("permissionQueryService")
public class PermissionQueryServiceImpl implements PermissionQueryService {

    @Resource
    private PermissionQueryDao permissionQueryDao;

    @Override
    public List<PermissionQueryResult> getAllPermission() {
        return permissionQueryDao.getAllPermissions();
    }

    @Override
    public PermissionQueryResult getPermissionById(Long id) {
        return permissionQueryDao.getPermissionById(id);
    }

    @Override
    public List<Long> getPermissionIdByRoleId(Long roleId) {
        return permissionQueryDao.getPermissionIdByRoleId(roleId);
    }
}
