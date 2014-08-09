package com.jonda.erp.wedding.web.order;

import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.biz.OrderQueryBiz;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/8/9.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderQueryBiz orderQueryBiz;

    @RequestMapping("/query")
    public String query(Model model, OrderQueryParam param){
        Page<OrderQueryResult> page = orderQueryBiz.queryOrder(param);
        model.addAttribute("page", page);
        model.addAttribute("param", param);
        return "wedding/order/index";
    }

}
