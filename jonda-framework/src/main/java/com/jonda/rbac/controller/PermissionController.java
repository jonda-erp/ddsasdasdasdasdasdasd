package com.jonda.rbac.controller;

import com.jonda.common.spring.web.AjaxResult;
import com.jonda.common.spring.web.BaseController;
import com.jonda.common.spring.web.StatusCodeEnum;
import com.jonda.rbac.controller.checker.PermissionParamChecker;
import com.jonda.rbac.domain.Permission;
import com.jonda.rbac.dto.result.PermissionQueryResult;
import com.jonda.rbac.service.PermissionManageService;
import com.jonda.rbac.service.PermissionQueryService;
import com.jonda.rbac.shiro.JondaRbacUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rejoady on 2014/7/25.
 */
@Controller
@RequestMapping("/rbac/permission")
public class PermissionController extends BaseController {

    @Resource
    private PermissionQueryService permissionQueryService;

    @Resource
    private PermissionManageService permissionManageService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<PermissionQueryResult> data = permissionQueryService.getAllPermission();
        model.addAttribute("data", data);
        return "rbac/permission/index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        return "rbac/permission/add";
    }

    @RequestMapping("/doAdd")
    public @ResponseBody String doAdd(Model model, Permission permission) {
        // 参数校验
        AjaxResult checkResult = PermissionParamChecker.checkParam(permission);
        if (checkResult != null) {
            return ajaxResult(checkResult);
        }
        JondaRbacUtil.setDataOperateInfo(permission);
        permissionManageService.addPermission(permission);
        AjaxResult ajaxResult = new AjaxResult("navTab_rbac_permission", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/modify")
    public String modify(Model model, Long id) {
        PermissionQueryResult data = permissionQueryService.getPermissionById(id);
        if (data == null) {
            throw new RuntimeException("修改数据不存在!");
        }
        model.addAttribute("data",data);
        return "rbac/permission/modify";
    }

    @RequestMapping("/doModify")
    public @ResponseBody String doModify(Model model, Permission permission) {
        // 参数校验
        AjaxResult checkResult = PermissionParamChecker.checkParam(permission, Boolean.TRUE);
        if (checkResult != null) {
            return ajaxResult(checkResult);
        }
        JondaRbacUtil.setDataOperateInfo(permission, Boolean.TRUE);
        permissionManageService.modifyPermission(permission);
        AjaxResult ajaxResult = new AjaxResult("navTab_rbac_permission", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/delete")
    public @ResponseBody String delete(Model model, Long id) {
        AjaxResult ajaxResult;
        if (id == null) {
            ajaxResult = new AjaxResult(StatusCodeEnum.ERROR, "操作失败");
            return ajaxResult(ajaxResult);
        }
        permissionManageService.deletePermission(id);
        ajaxResult = new AjaxResult("navTab_rbac_permission", "操作成功！");
        return ajaxResult(ajaxResult);
    }
}
