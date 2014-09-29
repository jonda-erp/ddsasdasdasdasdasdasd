package com.jonda.erp.wedding.web.order;

import com.jonda.common.dto.Page;
import com.jonda.common.spring.web.AjaxResult;
import com.jonda.common.spring.web.BaseController;
import com.jonda.common.spring.web.json.JsonResult;
import com.jonda.erp.utils.SerializeNoGenerator;
import com.jonda.erp.wedding.biz.manage.OrderManageBiz;
import com.jonda.erp.wedding.biz.query.OrderQueryBiz;
import com.jonda.erp.wedding.domain.wedding.order.Order;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import com.jonda.erp.wedding.enums.OrderStatusEnum;
import com.jonda.erp.wedding.enums.ProductTypeEnum;
import com.jonda.erp.wedding.enums.SerializeTypeEnum;
import com.jonda.erp.wedding.enums.UserTypeEnum;
import com.jonda.erp.wedding.web.order.util.OrderMVCUtil;
import com.jonda.rbac.shiro.JondaRbacUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

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

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("orderStatusEnum", OrderStatusEnum.values());
        return "wedding/order/index";
    }

    @RequestMapping(value = "/ajax/query")
    public @ResponseBody String query(Model model, OrderQueryParam param,
                                      String ssDate, String seDate){
        // 由于是ajax请求传入的参数，中文记得在页面编码，然后在Controller里面解码
        if (StringUtils.isNotBlank(param.getName())) {
            try {
                String name = java.net.URLDecoder.decode(param.getName(), "utf-8");
                param.setName(name);
            } catch (UnsupportedEncodingException e) {
                logger.error("[查询订单]解码请求参数[name]失败");
            }
        }
        param.setStartWeddingDate(OrderMVCUtil.string2Date(ssDate, "yyyy-MM-dd"));
        param.setEndWeddingDate(OrderMVCUtil.string2Date(seDate, "yyyy-MM-dd"));
        Page<OrderQueryResult> page = orderQueryBiz.queryOrder(param);
        return JsonResult.getJsonResult(page);
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("contactNo", SerializeNoGenerator.generate(SerializeTypeEnum.CONTRACT));
        return "wedding/order/add";
    }

    @RequestMapping(value = "/ajax/doAdd", method = RequestMethod.POST)
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
    public String modify(Model model, String orderNo) {
        OrderQueryResult order = orderQueryBiz.getByOrderNo(orderNo);
        model.addAttribute("data", order);
        return "wedding/order/modify";
    }

    @RequestMapping(value = "/ajax/doModify", method = RequestMethod.POST)
    public @ResponseBody String doModify(Model model, Order order, HttpServletRequest request) {
        AjaxResult ajaxResult;
        // 将传入的String类型的参数转换成Date
        order = OrderMVCUtil.setWeddingDate(order, request);
        // 参数校验
        ajaxResult = super.checkParam(order);
        if (ajaxResult != null) {
            return ajaxResult(ajaxResult);
        }
        // 设置操作人员信息
        JondaRbacUtil.setDataOperateInfo(order, Boolean.TRUE);
        JondaRbacUtil.setDataOperateInfo(order.getContract(), Boolean.TRUE);
        // 保存数据
        //orderManageBiz.createOrder(order);
        ajaxResult = new AjaxResult("navTab_wedding_order", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/detail")
    public String detail(Model model, String orderNo) {
        OrderQueryResult order = orderQueryBiz.getByOrderNo(orderNo);
        model.addAttribute("data", order);
        return "wedding/order/detail";
    }
}
