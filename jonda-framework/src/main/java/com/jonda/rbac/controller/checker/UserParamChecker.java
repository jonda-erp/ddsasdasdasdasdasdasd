package com.jonda.rbac.controller.checker;

import com.jonda.common.spring.web.AjaxResult;
import com.jonda.common.spring.web.StatusCodeEnum;
import com.jonda.rbac.domain.Role;
import com.jonda.rbac.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rejoady on 2014/7/28.
 */
public class UserParamChecker {

    private static final Logger logger = LoggerFactory.getLogger(UserParamChecker.class);

    /**
     * 参数校验
     *
     * @param user
     * @param modify
     * @return
     */
    public static AjaxResult checkParam(User user, Boolean ... modify) {
        if (user == null) {
            logger.error("spring mvc 获取页面传入的参数对象为空!");
            return new AjaxResult(StatusCodeEnum.ERROR, "系统错误，请联系管理员!");
        }

        // 数据修改，则判断ID是否为空
        if (modify != null && modify.length > 0 && modify[0] && user.getId() == null) {
            logger.error("修改用户信息，但是传入ID为空！");
            return new AjaxResult(StatusCodeEnum.ERROR, "系统错误，请联系管理员!");
        }

        return null;
    }

}
