package com.jonda.rbac.service.impl;

import com.jonda.common.util.PasswordUtil;
import com.jonda.rbac.dao.UserManageDao;
import com.jonda.rbac.dao.UserQueryDao;
import com.jonda.rbac.domain.Role;
import com.jonda.rbac.domain.User;
import com.jonda.rbac.dto.result.UserQueryResult;
import com.jonda.rbac.service.UserManageService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rejoady on 2014/7/19.
 */
@Transactional
@Service("userManageService")
public class UserManageServiceImpl implements UserManageService {

    @Resource
    private UserQueryDao userQueryDao;

    @Resource
    private UserManageDao userManageDao;

    @Override
    public boolean addUser(User user) {
        String salt = PasswordUtil.getPasswordSalt();
        String hashedPasswordBase64 = new Sha256Hash(user.getPassword(), salt, 1024).toBase64();
        user.setPassword(hashedPasswordBase64);
        user.setSalt(salt);
        userManageDao.addUser(user);
        return Boolean.TRUE;
    }

    @Override
    public boolean modifyUser(User user) {
        userManageDao.updateUser(user);
        return Boolean.TRUE;
    }

    @Override
    public boolean modifyPassword(User user) {
        String salt = PasswordUtil.getPasswordSalt();
        String hashedPasswordBase64 = new Sha256Hash(user.getPassword(), salt, 1024).toBase64();
        user.setPassword(hashedPasswordBase64);
        user.setSalt(salt);
        userManageDao.updatePassword(user);
        return Boolean.TRUE;
    }

    @Override
    public boolean deleteUser(Long userId) {
        userManageDao.deleteUser(userId);
        return Boolean.TRUE;
    }

    @Override
    public boolean distributeRole(Long userId, List<Long> roleIds) {
        UserQueryResult user = userQueryDao.getUserById(userId);
        if (user == null) {
            return Boolean.FALSE;
        }
        User domain = new User();
        domain.setId(user.getId());
        List<Role> roles = new ArrayList<Role>();
        for (Long roleId : roleIds) {
            Role role = new Role();
            role.setId(roleId);
            roles.add(role);
        }
        domain.setRoles(roles);

        userManageDao.deleteUserRole(userId);
        userManageDao.insertUserRoleBatch(domain);
        return Boolean.TRUE;
    }
}
