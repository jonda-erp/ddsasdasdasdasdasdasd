package com.jonda.rbac.controller.checker;

import com.jonda.common.spring.web.AjaxResult;
import com.jonda.common.spring.web.StatusCodeEnum;
import com.jonda.rbac.domain.Permission;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rejoady on 2014/7/28.
 */
public class PermissionParamChecker {

    private static final Logger logger = LoggerFactory.getLogger(PermissionParamChecker.class);

    /**
     * 参数校验
     *
     * @param permission
     * @param modify
     * @return
     */
    public static AjaxResult checkParam(Permission permission, Boolean ... modify) {
        if (permission == null) {
            logger.error("spring mvc 获取页面传入的参数对象为空!");
            return new AjaxResult(StatusCodeEnum.ERROR, "系统错误，请联系管理员!");
        }

        // 数据修改，则判断ID是否为空
        if (modify != null && modify.length > 0 && modify[0] && permission.getId() == null) {
            logger.error("修改权限，但是传入ID为空！");
            return new AjaxResult(StatusCodeEnum.ERROR, "系统错误，请联系管理员!");
        }

        if (StringUtils.isBlank(permission.getCode())) {
            return new AjaxResult(StatusCodeEnum.ERROR, "资源编码不能为空!");
        }
        if (StringUtils.isBlank(permission.getOperation())) {
            return new AjaxResult(StatusCodeEnum.ERROR, "资源操作编码不能为空!");
        }
        if (StringUtils.isBlank(permission.getUrl())) {
            return new AjaxResult(StatusCodeEnum.ERROR, "资源路径不能为空!");
        }

        if (!permission.getUrl().startsWith("/") || permission.getUrl().trim().length() < 2) {
            return new AjaxResult(StatusCodeEnum.ERROR, "资源路径格式不正确!");
        }

        if (StringUtils.isBlank(permission.getName())) {
            return new AjaxResult(StatusCodeEnum.ERROR, "权限名称不能为空!");
        }
        if (permission.getRanks() == null) {
            return new AjaxResult(StatusCodeEnum.ERROR, "权限优先级不能为空!");
        }
        if (permission.getRanks().intValue() > 999999 || permission.getRanks() < 100000) {
            return new AjaxResult(StatusCodeEnum.ERROR, "权限优先级格式不正确，请输入六位数字!");
        }
        return null;
    }

}
