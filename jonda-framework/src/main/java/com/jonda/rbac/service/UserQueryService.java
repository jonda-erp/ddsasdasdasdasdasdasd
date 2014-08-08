package com.jonda.rbac.service;

import com.jonda.common.dto.Page;
import com.jonda.rbac.domain.User;
import com.jonda.rbac.dto.param.UserQueryParam;
import com.jonda.rbac.dto.result.UserQueryResult;

/**
 * Created by rejoady on 2014/7/24.
 */
public interface UserQueryService {

    public User getUserAndPermissionInfo(String loginName);

    public User login(String loginName);

    public Page<UserQueryResult> queryUser(UserQueryParam param);

    public UserQueryResult getUserById(Long userId);

}
