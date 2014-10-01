package com.jonda.erp.wedding.web.order;

import com.jonda.common.spring.web.AjaxResult;
import com.jonda.common.spring.web.BaseController;
import com.jonda.common.spring.web.json.JsonResult;
import com.jonda.erp.wedding.biz.query.InvoiceQueryBiz;
import com.jonda.erp.wedding.biz.query.OrderQueryBiz;
import com.jonda.erp.wedding.domain.wedding.order.Invoice;
import com.jonda.erp.wedding.dto.invoice.InvoiceQueryResult;
import com.jonda.erp.wedding.enums.InvoiceFundTypeEnum;
import com.jonda.rbac.shiro.JondaRbacUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 发票管理
 *
 * Created by rejoady on 2014/8/9.
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private InvoiceQueryBiz invoiceQueryBiz;

    @Resource
    private OrderQueryBiz orderQueryBiz;

    @RequestMapping(value = "/index")
    public String index(Model model, String orderNo) {
        model.addAttribute("orderNo", orderNo);
        // 防止Ajax请求由于页面缓存不加载数据
        model.addAttribute("random", System.nanoTime());
        return "wedding/invoice/index";
    }

    @RequestMapping(value = "/ajax/query")
    public @ResponseBody String query(String orderNo){
        List<InvoiceQueryResult> data = invoiceQueryBiz.getInvoiceByOrderNo(orderNo);
        return JsonResult.getJsonResult(data);
    }

    @RequestMapping("/add")
    public String add(Model model, String orderNo){
        model.addAttribute("orderNo", orderNo);
        model.addAttribute("order", orderQueryBiz.getByOrderNo(orderNo));
        model.addAttribute("types", InvoiceFundTypeEnum.values());
        return "wedding/invoice/add";
    }

    @RequestMapping(value = "/ajax/doAdd", method = RequestMethod.POST)
    public @ResponseBody String doAdd(Model model, Invoice invoice) {
        AjaxResult ajaxResult;
        // 参数校验
        ajaxResult = super.checkParam(invoice);
        if (ajaxResult != null) {
            return ajaxResult(ajaxResult);
        }
        // 设置操作人员信息
        JondaRbacUtil.setDataOperateInfo(invoice);
        // 保存数据
        //orderManageBiz.createOrder(order);
        ajaxResult = new AjaxResult("closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

}