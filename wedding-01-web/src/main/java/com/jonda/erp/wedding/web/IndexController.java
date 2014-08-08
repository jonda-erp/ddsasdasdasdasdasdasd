package com.jonda.erp.wedding.web;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rejoady on 2014/7/17.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    private  static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    //@Autowired
    //private OrderBiz userBiz;

    @RequestMapping("index")
    public String index(Model model) {
//        UserDTO user = new UserDTO();
//        user.setName("管理员");
//        user.setLoginName("admin");
//        user.setPassword("admin");
//        user.setDepartmentId(1l);
//
//        userBiz.addUser(user);
        logger.info("访问首页");
        model.addAttribute("currentTime", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        return "index";
    }

}
