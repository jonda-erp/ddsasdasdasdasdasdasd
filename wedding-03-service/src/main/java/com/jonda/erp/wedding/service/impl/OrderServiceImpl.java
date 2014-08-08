package com.jonda.erp.wedding.service.impl;

import com.jonda.erp.wedding.dao.order.OrderQueryDao;
import com.jonda.erp.wedding.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rejoady on 2014/7/18.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderQueryDao orderQueryDao;

    /*@Override
    public void addUser(User user) {
        if (user == null) {
            return;
        }
        // 密码加密处理
        String planPassword = user.getPassword();
        String salt = PasswordUtil.getPasswordSalt();
        String encryptPassword = PasswordUtil.encryptPassword(planPassword, salt);
        user.setSalt(salt);
        user.setPassword(encryptPassword);
        logger.info("添加新用户！");
        //userDao.save(user);
    }*/

}
