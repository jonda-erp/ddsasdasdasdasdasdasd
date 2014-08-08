package com.jonda.rbac.service;

import com.jonda.rbac.domain.Permission;
import com.jonda.rbac.domain.Role;
import com.jonda.rbac.dto.result.RoleQueryResult;

import java.util.List;

/**
 * Created by rejoady on 2014/7/27.
 */
public interface RoleManageService {

    /**
     * 添加角色定义
     *
     * @param role
     * @return
     */
    public boolean addRole(Role role);

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    public boolean modifyRole(Role role);

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    public boolean deleteRole(Long roleId);

    /**
     * 分配权限
     *
     * @param roleId 角色ID
     * @param permissionIds 该角色所拥有的权限列表
     * @return
     */
    public boolean distributePermission(Long roleId, List<Long> permissionIds);
}
