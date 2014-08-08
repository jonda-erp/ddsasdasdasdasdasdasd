package com.jonda.rbac.dao;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.rbac.dto.result.RoleQueryResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by rejoady on 2014/7/21.
 */
@MyBatisRepository
public interface RoleQueryDao {

    @Select("select id, name, code, description, " +
            "creator, create_time as createTime, modifier,modify_time as modifyTime " +
            "from rbac_role where data_status=1")
    public List<RoleQueryResult> getAllRoles();

    @Select("select id, code, name, description, " +
            "creator, create_time as createTime, modifier,modify_time as modifyTime " +
            "from rbac_role where id=#{id} and data_status=1")
    public RoleQueryResult getRoleById(@Param("id") Long id);

    @Select("select role_id from rbac_user_role where user_id=#{userId}")
    public List<Long> getRoleByUserId(@Param("userId")Long userId);
}
