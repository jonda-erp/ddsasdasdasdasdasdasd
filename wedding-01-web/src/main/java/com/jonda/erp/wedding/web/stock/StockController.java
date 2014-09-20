package com.jonda.erp.wedding.web.stock;

import com.jonda.common.dto.Page;
import com.jonda.common.spring.web.BaseController;
import com.jonda.common.spring.web.json.JsonResult;
import com.jonda.erp.wedding.biz.query.OrderQueryBiz;
import com.jonda.erp.wedding.biz.query.ProductUseQueryBiz;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;
import com.jonda.erp.wedding.dto.product.ProductUseParam;
import com.jonda.erp.wedding.dto.product.ProductUseResult;
import com.jonda.erp.wedding.enums.OrderStatusEnum;
import com.jonda.erp.wedding.web.order.util.OrderMVCUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2014/8/19.
 */
@Controller
@RequestMapping("/stock")
public class StockController extends BaseController {
    @Resource
    private ProductUseQueryBiz productUseQueryBiz;
    @Resource
    private OrderQueryBiz orderQueryBiz;

    private static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @RequestMapping("/apply")
    public String apply(Model model){
        return "wedding/stock/apply";
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("orderStatusEnum", OrderStatusEnum.values());
        return "wedding/stock/businessOut_main";
    }

    @RequestMapping("/busiOutByContract")
    public String busiOutByContract(Model model, String contractNo){
        model.addAttribute("contractNo",contractNo);
        return "wedding/stock/busiOutByContractId";
    }

    @RequestMapping(value = "/ajax/query")
    public @ResponseBody
    String query(Model model,ProductUseParam param, String contractNo){
        param.setContractId(contractNo);
        Page<ProductUseResult> page = productUseQueryBiz.queryProductUse(param);
        logger.info("xxxxxxxxxxx");
        logger.info("jsonStr:"+JsonResult.getJsonResult(page));
        return JsonResult.getJsonResult(page);
    }
}
