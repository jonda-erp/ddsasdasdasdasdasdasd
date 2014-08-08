package com.jonda.rbac.service;

import com.jonda.rbac.dto.result.PermissionQueryResult;
import com.jonda.rbac.dto.result.RoleQueryResult;

import java.util.List;

/**
 * Created by rejoady on 2014/7/27.
 */
public interface RoleQueryService {

    /**
     * 查询所有的权限
     *
     * @return
     */
    public List<RoleQueryResult> getAllRole();

    /**
     * 根据ID获取指定的角色信息
     *
     * @param id
     * @return
     */
    public RoleQueryResult getRoleById(Long id);

    /**
     * 根据用户ID获取用户所拥有的角色ID列表
     *
     * @param userId
     * @return
     */
    public List<Long> getRoleByUserId(Long userId);

}
