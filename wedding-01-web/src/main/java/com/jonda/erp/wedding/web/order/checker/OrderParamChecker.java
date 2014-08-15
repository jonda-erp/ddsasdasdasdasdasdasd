package com.jonda.erp.wedding.web.order.checker;

import com.jonda.common.spring.web.AjaxResult;
import com.jonda.common.spring.web.StatusCodeEnum;
import com.jonda.erp.wedding.domain.wedding.order.Order;
import com.jonda.rbac.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rejoady on 2014/7/28.
 */
public class OrderParamChecker {

    private static final Logger logger = LoggerFactory.getLogger(OrderParamChecker.class);

    /**
     * 参数校验
     *
     * @param order
     * @param modify
     * @return
     */
    public static AjaxResult checkParam(Order order, Boolean ... modify) {
        if (order == null) {
            logger.error("spring mvc 获取页面传入的参数对象为空!");
            return new AjaxResult(StatusCodeEnum.ERROR, "系统错误，请联系管理员!");
        }

        if (order.getWeddingDate() == null) {
            return new AjaxResult(StatusCodeEnum.ERROR, "婚庆日期不能为空，请选择婚庆日期!");
        }

        if (StringUtils.isBlank(order.getBridegroomTelephone())
                && StringUtils.isBlank(order.getBrideTelephone())) {
            return new AjaxResult(StatusCodeEnum.ERROR, "新娘电话和新郎电话请至少填写一个!");
        }

        // 数据修改，则判断ID是否为空
        if (modify != null && modify.length > 0 && modify[0] && order.getId() == null) {
            logger.error("修改用户信息，但是传入ID为空！");
            return new AjaxResult(StatusCodeEnum.ERROR, "系统错误，请联系管理员!");
        }

        return null;
    }

}
