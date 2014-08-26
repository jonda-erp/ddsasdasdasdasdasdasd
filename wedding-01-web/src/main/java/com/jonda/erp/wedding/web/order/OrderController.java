package com.jonda.erp.wedding.web.order;

import com.jonda.common.dto.Page;
import com.jonda.common.spring.web.AjaxResult;
import com.jonda.common.spring.web.BaseController;
import com.jonda.erp.wedding.biz.manage.OrderManageBiz;
import com.jonda.erp.wedding.biz.query.OrderQueryBiz;
import com.jonda.erp.wedding.domain.wedding.order.Order;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import com.jonda.erp.wedding.enums.OrderStatusEnum;
import com.jonda.erp.wedding.enums.ProductTypeEnum;
import com.jonda.erp.wedding.enums.UserTypeEnum;
import com.jonda.erp.wedding.web.order.checker.OrderParamChecker;
import com.jonda.erp.wedding.web.order.util.OrderMVCUtil;
import com.jonda.rbac.shiro.JondaRbacUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by rejoady on 2014/8/9.
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Resource
    private OrderQueryBiz orderQueryBiz;

    @Resource
    private OrderManageBiz orderManageBiz;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("/query")
    public String query(Model model, OrderQueryParam param, String ssDate, String seDate){
        param.setStartWeddingDate(OrderMVCUtil.string2Date(ssDate, "yyyy-MM-dd"));
        param.setEndWeddingDate(OrderMVCUtil.string2Date(seDate, "yyyy-MM-dd"));
        Page<OrderQueryResult> page = orderQueryBiz.queryOrder(param);
        model.addAttribute("page", page);
        model.addAttribute("param", param);
        model.addAttribute("ssDate", ssDate);
        model.addAttribute("seDate", seDate);
        model.addAttribute("orderStatusEnum", OrderStatusEnum.values());
        return "wedding/order/index";
    }

    @RequestMapping("/add")
    public String add(Model model){
        // TODO 后续可将这两种类型放在数据库通过功能维护
        model.addAttribute("user_type", UserTypeEnum.values());
        model.addAttribute("product_type", ProductTypeEnum.values());
        return "wedding/order/add";
    }

    @RequestMapping(value = "doAdd", method = RequestMethod.POST)
    public @ResponseBody String doAdd(Model model, Order order, HttpServletRequest request) {
        AjaxResult ajaxResult;
        // 将传入的String类型的参数转换成Date
        order = OrderMVCUtil.setWeddingDate(order, request);
        // 参数校验
        ajaxResult = super.checkParam(order);
        if (ajaxResult != null) {
            return ajaxResult(ajaxResult);
        }
        // 设置操作人员信息
        JondaRbacUtil.setDataOperateInfo(order);
        JondaRbacUtil.setDataOperateInfo(order.getContract());
        // 保存数据
        orderManageBiz.createOrder(order);
        ajaxResult = new AjaxResult("navTab_wedding_order", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/modify")
    public String modify(Model model, Long id) {

        return "wedding/order/modify";
    }
}
