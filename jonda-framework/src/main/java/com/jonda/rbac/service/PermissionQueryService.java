package com.jonda.rbac.service;

import com.jonda.rbac.dto.result.PermissionQueryResult;

import java.util.List;

/**
 * Created by rejoady on 2014/7/27.
 */
public interface PermissionQueryService {

    /**
     * 查询所有的权限
     *
     * @return
     */
    public List<PermissionQueryResult> getAllPermission();

    /**
     * 根据Id获取一条权限信息
     *
     * @param id
     * @return
     */
    public PermissionQueryResult getPermissionById(Long id);

    /**
     * 根据角色ID查询角色拥有的权限ID
     *
     * @param roleId
     * @return
     */
    public List<Long> getPermissionIdByRoleId(Long roleId);
}
