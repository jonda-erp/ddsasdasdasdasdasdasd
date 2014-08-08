package com.jonda.rbac.dao;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.rbac.domain.User;
import com.jonda.rbac.dto.result.UserQueryResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by rejoady on 2014/7/19.
 */
@MyBatisRepository
public interface UserQueryDao {

    public User getUserAndPermissionInfo(String loginName);

    public User getLoginInfo(String loginName);

    public UserQueryResult getUserById(Long userId);

}
