package com.jonda.rbac.shiro.access;

import com.jonda.rbac.dto.result.PermissionQueryResult;

import java.util.List;

/**
 * 权限提供，获取系统设置的基础资源权限信息
 *
 * Created by rejoady on 2014/7/21.
 */
public interface AccessPermissionProvider {

    /**
     * 权限提供
     *
     * @return
     */
    public List<PermissionQueryResult> provide();

}
