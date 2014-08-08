package com.jonda.rbac.service;

import com.jonda.rbac.domain.User;

import java.util.List;

/**
 * Created by rejoady on 2014/7/19.
 */
public interface UserManageService {

    /**
     * 添加系统用户定义
     *
     * @param user
     * @return
     */
    public boolean addUser(User user);

    /**
     * 修改系统用户
     *
     * @param user
     * @return
     */
    public boolean modifyUser(User user);

    /**
     * 强制修改用户密码
     *
     * @param user
     * @return
     */
    public boolean modifyPassword(User user);

    /**
     * 删除系统用户
     *
     * @param userId
     * @return
     */
    public boolean deleteUser(Long userId);

    /**
     * 分配角色
     *
     * @param userId 用户ID
     * @param roleIds 该用户所拥有的所有角色
     * @return
     */
    public boolean distributeRole(Long userId, List<Long> roleIds);

}
