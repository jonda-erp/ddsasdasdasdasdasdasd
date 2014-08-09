package com.jonda.rbac.service.impl;

import com.jonda.rbac.dao.RoleManageDao;
import com.jonda.rbac.dao.RoleQueryDao;
import com.jonda.rbac.domain.Permission;
import com.jonda.rbac.domain.Role;
import com.jonda.rbac.dto.result.RoleQueryResult;
import com.jonda.rbac.service.RoleManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rejoady on 2014/7/30.
 */
@Transactional
@Service("roleManageService")
public class RoleManageServiceImpl implements RoleManageService {

    private static final Logger logger = LoggerFactory.getLogger(RoleManageService.class);

    @Resource
    private RoleManageDao roleManageDao;

    @Resource
    private RoleQueryDao roleQueryDao;

    @Override
    public boolean addRole(Role role) {
        roleManageDao.addRole(role);
        return Boolean.TRUE;
    }

    @Override
    public boolean modifyRole(Role role) {
        roleManageDao.updateRole(role);
        return Boolean.TRUE;
    }

    @Override
    public boolean deleteRole(Long roleId) {
        roleManageDao.deleteRole(roleId);
        return Boolean.TRUE;
    }

    @Override
    public boolean distributePermission(Long roleId, List<Long> permissionIds) {
        RoleQueryResult role = roleQueryDao.getRoleById(roleId);
        if (role == null) {
            return Boolean.FALSE;
        }
        Role domain = new Role();
        domain.setId(role.getId());
        List<Permission> permissions = new ArrayList<Permission>();
        for (Long permissionId : permissionIds) {
            Permission permission = new Permission();
            permission.setId(permissionId);
            permissions.add(permission);
        }
        domain.setPermissions(permissions);

        roleManageDao.deleteRolePermission(roleId);
        roleManageDao.insertRolePermissionBatch(domain);
        return Boolean.TRUE;
    }
}
