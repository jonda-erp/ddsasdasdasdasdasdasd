package com.jonda.erp.wedding.service.impl;

import com.jonda.erp.wedding.dao.order.ContractManageDao;
import com.jonda.erp.wedding.dao.order.OrderManageDao;
import com.jonda.erp.wedding.domain.wedding.order.Contract;
import com.jonda.erp.wedding.domain.wedding.order.Order;
import com.jonda.erp.wedding.enums.OrderStatusEnum;
import com.jonda.erp.wedding.service.OrderManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/8/15.
 */
@Transactional
@Service("orderManageService")
public class OrderManageServiceImpl implements OrderManageService{

    @Resource
    private OrderManageDao orderManageDao;

    @Resource
    private ContractManageDao contractManageDao;

    @Override
    public Boolean createOrder(Order order) {
        order.setStatus(OrderStatusEnum.INIT.getCode());
        orderManageDao.addOrder(order);
        Contract contract = order.getContract();
        contract.setOrder(order);
        contractManageDao.addContract(contract);
        return Boolean.TRUE;
    }
}
