package com.jonda.rbac.dao;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.rbac.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by rejoady on 2014/7/21.
 */
@MyBatisRepository
public interface PermissionManageDao {


    @Insert("insert into rbac_permission" +
                "(code, operation, url, name, description, ranks, creator, create_time, modifier, data_status)" +
            "values" +
                "(#{code}, #{operation}, #{url}, #{name}, #{description}, #{ranks}, #{creator}, SYSDATE(), #{modifier}, 1)")
    public void addPermission(Permission permission);

    @Update("update rbac_permission set " +
            "code=#{code}, operation=#{operation}, " +
            "url=#{url}, name=#{name},description=#{description}, ranks=#{ranks}, modifier=#{modifier} " +
            "where id=#{id}")
    public void updatePermission(Permission permission);


    @Update("update rbac_permission set " +
                "data_status=0 " +
            "where id=#{id}")
    public void deletePermission(@Param("id")Long id);

}
