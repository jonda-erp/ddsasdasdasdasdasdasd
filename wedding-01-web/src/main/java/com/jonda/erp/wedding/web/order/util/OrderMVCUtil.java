package com.jonda.erp.wedding.web.order.util;

import com.jonda.common.spring.web.AjaxResult;
import com.jonda.common.spring.web.StatusCodeEnum;
import com.jonda.common.util.JondaDateParser;
import com.jonda.erp.wedding.domain.wedding.Product;
import com.jonda.erp.wedding.domain.wedding.order.Contract;
import com.jonda.erp.wedding.domain.wedding.order.Order;
import com.jonda.erp.wedding.domain.wedding.order.ProductUse;
import com.jonda.erp.wedding.domain.wedding.order.WorkerRequired;
import com.jonda.erp.wedding.enums.ProductTypeEnum;
import com.jonda.erp.wedding.enums.UserTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rejoady on 2014/8/13.
 */
public class OrderMVCUtil {

    private static final Logger logger = LoggerFactory.getLogger(OrderMVCUtil.class);

    /**
     * 将request中的String类型的婚庆日期转换成Date类型
     *
     * @param order
     * @param request
     * @return
     */
    public static Order setWeddingDate(Order order, HttpServletRequest request) {
        String sDate = request.getParameter("sDate");
        if (order != null && StringUtils.isNotBlank(sDate)) {
            try {
                order.setWeddingDate(new JondaDateParser("yyyy-MM-dd").parse(sDate));
            } catch (Exception ex) {
                logger.error("用户输入日期格式错误, 转换发生异常，message:{}", ex.getMessage(), ex);
            }
        }
        return order;
    }

    /**
     * 设置需求的人员和道具信息
     *
     * @param order
     * @param request
     * @return
     */
//    public static Order setExtendsInfo(Order order, HttpServletRequest request) {
//        if (order == null) return order;
//        if (order.getContract() == null) {
//            order.setContract(new Contract());
//        }
//        // 人员需求
//        List<WorkerRequired> workerNeed = new ArrayList<WorkerRequired>();
//        for (UserTypeEnum u : UserTypeEnum.values()) {
//            String value = request.getParameter(u.getCode());
//            if (StringUtils.isNotBlank(value)) {
//                WorkerRequired wr = new WorkerRequired();
//                wr.setContract(order.getContract());
//                wr.setUserRole(u.getCode());
//                wr.setRemark(u.getMessage());
//                wr.setCount(Integer.valueOf(value));
//                workerNeed.add(wr);
//            }
//        }
//        order.getContract().setWorkerRequireds(workerNeed);
//
//        // 道具需求
//        List<ProductUse> productUses = new ArrayList<ProductUse>();
//        for (ProductTypeEnum p : ProductTypeEnum.values()) {
//            String value = request.getParameter(p.getCode());
//            if (StringUtils.isNotBlank(value)) {
//                ProductUse pu = new ProductUse();
//                pu.setContract(order.getContract());
//                pu.setProduct(new Product());
//                pu.setCount(Integer.valueOf(value));
//                productUses.add(pu);
//            }
//        }
//        order.getContract().setProductUses(productUses);
//
//        return order;
//    }
}
