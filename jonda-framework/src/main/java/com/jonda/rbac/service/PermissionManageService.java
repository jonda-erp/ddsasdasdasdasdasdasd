package com.jonda.rbac.service;

import com.jonda.rbac.domain.Permission;
import com.jonda.rbac.dto.result.PermissionQueryResult;

import java.util.List;

/**
 * Created by rejoady on 2014/7/27.
 */
public interface PermissionManageService {

    /**
     * 新增权限
     *
     * @return
     */
    public boolean addPermission(Permission permission);

    /**
     * 修改权限信息
     *
     * @param permission
     * @return
     */
    public boolean modifyPermission(Permission permission);

    /**
     * 删除一条权限信息
     *
     * @param id
     * @return
     */
    public boolean deletePermission(Long id);
}
