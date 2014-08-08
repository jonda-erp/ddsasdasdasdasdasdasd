package com.jonda.rbac;

import com.jonda.rbac.domain.Permission;
import com.jonda.rbac.domain.Role;
import com.jonda.rbac.domain.User;
import com.jonda.rbac.service.UserQueryService;
import com.jonda.rbac.shiro.JondaRbacUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by rejoady on 2014/7/19.
 */
public class ShiroDbRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Resource
    private UserQueryService userQueryService;

    public ShiroDbRealm() {
        setName("shiroDBRealm"); // This name must match the name in the User class's getPrincipals() method
    }

    /**
     * 用户访问资源的权限确认
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String loginName = (String)principals.fromRealm(getName()).iterator().next() ;
        User user = userQueryService.getUserAndPermissionInfo(loginName) ;
        if (user == null) {
            return null;
        } else {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            List<String> roles = new ArrayList<String>() ;
            List<String> permissions = new ArrayList<String>() ;

            List<Role> urs = user.getRoles();
            String permission;
            for (Role role : urs) {
                // 设置用户角色
                roles.add(role.getCode());
                List<Permission> rps = role.getPermissions() ;
                for (Permission per : rps) {
                    // 设置权限，这里的权限是分层表示，
                    // 如user:add可以表示用户增加权限，而user:modify:department1则
                    // 可以表示对department1部门用户的修改权限。采用这种方式可以轻松控制数据访问和操作权限
                    if(per != null) {
                        //资源
                        if (StringUtils.isBlank(per.getOperation())) {
                            permission = per.getCode();
                        } else {
                            permission = per.getCode() + ":" + per.getOperation();
                        }
                        permissions.add(permission) ;
                    }
                }
            }
            info.addRoles(roles) ;
            info.addStringPermissions(permissions);

            return info;
        }
    }

    /**
     * 用户登录的授权接口，判断用户输入密码是否正确
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("获取用户信息...");
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String loginName = upToken.getUsername();
        User user = userQueryService.getUserAndPermissionInfo(loginName);
        if (user == null) {
            logger.info("用户名不存在...");
            return null;
        } else {
            JondaRbacUtil.setCurrentUser(user);
            logger.info("获取用户信息成功...");
            String salt = user.getSalt();
            logger.debug("用户输入密码：{}, salt ：{}, 密码加密结果：{}", upToken.getPassword(), salt, new Sha256Hash(upToken.getPassword(), user.getSalt(),1024).toBase64());
            if (StringUtils.isNoneBlank(salt)) {
                ByteSource byteSource = new SimpleByteSource(salt);
                return new SimpleAuthenticationInfo(user.getLoginName(),user.getPassword(), byteSource, getName());
            } else {
                return new SimpleAuthenticationInfo(user.getLoginName(),user.getPassword(),getName());
            }
        }

    }



}
