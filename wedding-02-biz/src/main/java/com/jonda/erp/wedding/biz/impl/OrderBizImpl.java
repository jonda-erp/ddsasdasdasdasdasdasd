package com.jonda.erp.wedding.biz.impl;

import com.jonda.erp.wedding.biz.OrderBiz;
import com.jonda.erp.wedding.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rejoady on 2014/7/18.
 */
@Component("userBiz")
public class OrderBizImpl implements OrderBiz {

    private static final Logger logger = LoggerFactory.getLogger(OrderBiz.class);

    @Autowired
    private OrderService orderService;

    /*@Override
    public void addUser(UserDTO user) {
        logger.info("添加后台新用户！");
        User userDomain = new User();
        userDomain.copyProperties(user);
        try {
            orderService.addUser(userDomain);
        } catch (Exception e) {
            logger.error("添加用户发生异常，ex:", e);
        }

    }*/
}
