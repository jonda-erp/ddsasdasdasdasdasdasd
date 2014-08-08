package com.jonda.rbac.shiro;

import com.jonda.rbac.dto.result.PermissionQueryResult;
import com.jonda.rbac.shiro.access.AccessPermissionProvider;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.config.Ini;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rejoady on 2014/7/24.
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

    private static final Logger logger = LoggerFactory.getLogger(ChainDefinitionSectionMetaSource.class);

    @Resource
    private AccessPermissionProvider accessPermissionProvider;

    private String filterChainDefinitions;

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    @Override
    public Ini.Section getObject() throws Exception {
        //获取所有Resource
        List<PermissionQueryResult> permissions = accessPermissionProvider.provide();

        Ini ini = new Ini();
        //加载默认的url
        ini.load(filterChainDefinitions);

        logger.info("增加默认权限设置:\n{}", filterChainDefinitions) ;
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        //循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
        //里面的键就是链接URL,值就是存在什么条件才能访问该链接
        for (Iterator<PermissionQueryResult> it = permissions.iterator(); it.hasNext();) {
            PermissionQueryResult permission = it.next();

            String resourceCode = permission.getCode();
            String operation = permission.getOperation();
            StringBuffer permissionCode = new StringBuffer();
            // 如果不为空值添加到section中
            if (StringUtils.isBlank(resourceCode) || StringUtils.isBlank(operation)) {
                permissionCode.append(resourceCode).append(operation);
            } else {
                permissionCode.append("perms[").append(permission.getCode()).append(":");
                permissionCode.append(permission.getOperation()).append("]");
            }

            if(StringUtils.isNotEmpty(permissionCode) && StringUtils.isNotEmpty(permission.getUrl())) {
                section.put(permission.getUrl(), permissionCode.toString());
                logger.info("增加权限设置: {} - {}, ---- [{}]", permissionCode, permission.getUrl(), permission.getRanks()) ;
            }

        }

        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

