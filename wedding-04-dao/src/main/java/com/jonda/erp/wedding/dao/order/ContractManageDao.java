package com.jonda.erp.wedding.dao.order;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.erp.wedding.domain.wedding.order.Contract;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by rejoady on 2014/8/15.
 */
@MyBatisRepository
public interface ContractManageDao {

    @Insert("insert into wedding_contract" +
            "(order_id, contract_no, contract_content, creator, create_time, modifier, data_status)" +
            "values" +
            "(#{order.id}, #{contractNo}, #{content}, #{creator}, SYSDATE(), #{modifier}, 1)")
    public void addContract(Contract contract);

}
