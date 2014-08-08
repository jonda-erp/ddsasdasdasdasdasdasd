package com.jonda.rbac.shiro.access.provider;

import com.jonda.rbac.domain.Permission;
import com.jonda.rbac.dto.result.PermissionQueryResult;
import com.jonda.rbac.shiro.access.AccessPermissionProvider;

import java.util.List;

/**
 * 默认的XML文件配置提供
 *
 *
 * Created by rejoady on 2014/7/21.
 */
public class DefaultXmlProvider implements AccessPermissionProvider {

    @Override
    public List<PermissionQueryResult> provide() {
        return null;
    }

}
