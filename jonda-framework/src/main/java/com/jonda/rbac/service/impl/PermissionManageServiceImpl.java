package com.jonda.rbac.service.impl;

import com.jonda.rbac.dao.PermissionManageDao;
import com.jonda.rbac.domain.Permission;
import com.jonda.rbac.service.PermissionManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/7/28.
 */
@Transactional
@Service("permissionManageService")
public class PermissionManageServiceImpl implements PermissionManageService {

    @Resource
    private PermissionManageDao permissionManageDao;

    @Override
    public boolean addPermission(Permission permission) {
        permissionManageDao.addPermission(permission);
        return Boolean.TRUE;
    }

    @Override
    public boolean modifyPermission(Permission permission) {
        permissionManageDao.updatePermission(permission);
        return Boolean.TRUE;
    }

    @Override
    public boolean deletePermission(Long id) {
        permissionManageDao.deletePermission(id);
        return Boolean.TRUE;
    }
}
