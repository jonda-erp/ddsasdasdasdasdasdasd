package com.jonda.rbac.dao;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.rbac.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by rejoady on 2014/7/21.
 */
@MyBatisRepository
public interface UserManageDao {

    @Insert("insert into rbac_user" +
            "(department_id, login_name, password, salt, name, remark, creator, create_time, modifier, data_status)" +
            "values" +
            "(#{department.id}, #{loginName}, #{password}, #{salt}, #{name}, #{remark}, #{creator}, SYSDATE(), #{modifier}, 1)")
    public void addUser(User user);

    @Update("update rbac_user set " +
            "department_id=#{department.id}, login_name=#{loginName}, name=#{name},remark=#{remark}, modifier=#{modifier} " +
            "where id=#{id}")
    public void updateUser(User user);

    @Update("update rbac_user set " +
            "password=#{password}, salt=#{salt}, modifier=#{modifier} " +
            "where id=#{id}")
    public void updatePassword(User user);

    @Update("update rbac_user set data_status=0 where id=#{id}")
    public void deleteUser(@Param("id") Long id);

    @Delete("delete from rbac_user_role where user_id=#{userId}")
    public void deleteUserRole(@Param("userId") Long userId);

    public void insertUserRoleBatch(User user);
}
