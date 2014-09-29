package com.jonda.erp.wedding.dao.order;


import com.jonda.common.dao.MyBatisRepository;
import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import org.apache.ibatis.annotations.Param;

/**
 * Created by rejoady on 2014/7/20.
 */
@MyBatisRepository
public interface OrderQueryDao {

    public OrderQueryResult getByNo(@Param("orderNo")String orderNo);

}
