package com.jonda.rbac.service.impl;

import com.jonda.common.dao.PageQueryDao;
import com.jonda.common.dto.Page;
import com.jonda.rbac.dao.UserQueryDao;
import com.jonda.rbac.domain.User;
import com.jonda.rbac.dto.param.UserQueryParam;
import com.jonda.rbac.dto.result.UserQueryResult;
import com.jonda.rbac.service.UserQueryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/7/24.
 */
@Service("userQueryService")
public class UserQueryServiceImpl implements UserQueryService {

    @Resource
    private UserQueryDao userQueryDao;

    @Resource
    private PageQueryDao pageQueryDao;

    @Override
    public User getUserAndPermissionInfo(String loginName) {
        if (StringUtils.isBlank(loginName)) {
            return null;
        }
        User user = userQueryDao.getUserAndPermissionInfo(loginName);
        return user;
    }

    @Override
    public User login(String loginName) {
        if (StringUtils.isBlank(loginName)) {
            return null;
        }
        User user = userQueryDao.getLoginInfo(loginName);
        return user;
    }

    @Override
    public Page<UserQueryResult> queryUser(UserQueryParam param) {
        return pageQueryDao.query("com.jonda.rbac.dao.UserQueryDao.queryUser", param);
    }

    @Override
    public UserQueryResult getUserById(Long userId) {
        return userQueryDao.getUserById(userId);
    }
}
