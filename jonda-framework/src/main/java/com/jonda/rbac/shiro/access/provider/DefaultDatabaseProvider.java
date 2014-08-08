package com.jonda.rbac.shiro.access.provider;

import com.jonda.rbac.dao.PermissionQueryDao;
import com.jonda.rbac.dto.result.PermissionQueryResult;
import com.jonda.rbac.shiro.access.AccessPermissionProvider;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 默认的数据库权限信息提供
 *
 * Created by rejoady on 2014/7/21.
 */
@Component("accessPermissionProvider")
public class DefaultDatabaseProvider implements AccessPermissionProvider {

    @Resource
    private PermissionQueryDao permissionQueryDao;

    @Override
    public List<PermissionQueryResult> provide() {
        List<PermissionQueryResult> permissions = permissionQueryDao.getAllPermissions();
        if (permissions == null) {
            permissions = new ArrayList<PermissionQueryResult>();
        }
        List<PermissionQueryResult> rbacPermissions = new ArrayList<PermissionQueryResult>();
        permissions.addAll(rbacPermissions);
        Collections.sort(permissions);
        return permissions;
    }
}
