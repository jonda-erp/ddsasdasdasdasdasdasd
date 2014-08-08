package com.jonda.rbac.dao;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.rbac.dto.result.PermissionQueryResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by rejoady on 2014/7/21.
 */
@MyBatisRepository
public interface PermissionQueryDao {

    @Select("select id, code, operation, url, name, description, ranks, " +
            "creator, create_time as createTime, modifier,modify_time as modifyTime " +
            "from rbac_permission where data_status=1")
    public List<PermissionQueryResult> getAllPermissions();

    @Select("select id, code, operation, url, name, description, ranks, " +
            "creator, create_time as createTime, modifier,modify_time as modifyTime " +
            "from rbac_permission where id=#{id} and data_status=1")
    public PermissionQueryResult getPermissionById(@Param("id")Long id);

    @Select("select permission_id from rbac_role_permission where role_id=#{roleId}")
    public List<Long> getPermissionIdByRoleId(@Param("roleId")Long roleId);
}
