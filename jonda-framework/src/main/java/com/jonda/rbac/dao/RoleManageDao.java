package com.jonda.rbac.dao;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.rbac.domain.Role;
import org.apache.ibatis.annotations.*;

/**
 * Created by rejoady on 2014/7/21.
 */
@MyBatisRepository
public interface RoleManageDao {

    @Insert("insert into rbac_role" +
            "(code, name, description, creator, create_time, modifier, data_status)" +
            "values" +
            "(#{code}, #{name}, #{description}, #{creator}, SYSDATE(), #{modifier}, 1)")
    public void addRole(Role role);

    @Update("update rbac_role set " +
            "code=#{code}, name=#{name},description=#{description}, modifier=#{modifier} " +
            "where id=#{id}")
    public void updateRole(Role role);


    @Update("update rbac_role set data_status=0 where id=#{id}")
    public void deleteRole(@Param("id")Long id);

    @Delete("delete from rbac_role_permission where role_id=#{roleId}")
    public void deleteRolePermission(@Param("roleId")Long roleId);

    public void insertRolePermissionBatch(Role role);
}
