package com.jonda.erp.wedding.web.stock;

import com.jonda.common.dto.Page;
import com.jonda.common.spring.web.BaseController;
import com.jonda.erp.wedding.biz.query.OrderQueryBiz;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import com.jonda.erp.wedding.enums.OrderStatusEnum;
import com.jonda.erp.wedding.web.order.util.OrderMVCUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2014/8/19.
 */
@Controller
@RequestMapping("/stock")
public class StockController extends BaseController {
    @Resource
    private OrderQueryBiz orderQueryBiz;

    private static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @RequestMapping("/apply")
    public String apply(Model model){
        return "wedding/stock/apply";
    }

    @RequestMapping("/businessOut")
    public String businessOut(Model model, OrderQueryParam param, String ssDate, String seDate){
        param.setStartWeddingDate(OrderMVCUtil.string2Date(ssDate, "yyyy-MM-dd"));
        param.setEndWeddingDate(OrderMVCUtil.string2Date(seDate, "yyyy-MM-dd"));
        Page<OrderQueryResult> page = orderQueryBiz.queryOrder(param);
        model.addAttribute("page", page);
        model.addAttribute("param", param);
        model.addAttribute("ssDate", ssDate);
        model.addAttribute("seDate", seDate);
        model.addAttribute("orderStatusEnum", OrderStatusEnum.values());
        return "wedding/stock/businessOut_main";
    }

    @RequestMapping("/busiOutByContract")
    public String busiOutByContract(Model model,String contractId){
        return "wedding/stock/busiOutByContractId";
    }
}