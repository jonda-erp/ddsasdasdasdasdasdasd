package com.jonda.rbac.controller;

import com.jonda.common.spring.web.AjaxResult;
import com.jonda.common.spring.web.BaseController;
import com.jonda.common.spring.web.StatusCodeEnum;
import com.jonda.rbac.controller.checker.RoleParamChecker;
import com.jonda.rbac.domain.Role;
import com.jonda.rbac.dto.result.PermissionQueryResult;
import com.jonda.rbac.dto.result.RoleQueryResult;
import com.jonda.rbac.service.PermissionQueryService;
import com.jonda.rbac.service.RoleManageService;
import com.jonda.rbac.service.RoleQueryService;
import com.jonda.rbac.shiro.JondaRbacUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rejoady on 2014/7/25.
 */
@Controller
@RequestMapping("/rbac/role")
public class RoleController extends BaseController {

    @Resource
    private RoleQueryService roleQueryService;

    @Resource
    private RoleManageService roleManageService;

    @Resource
    private PermissionQueryService permissionQueryService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<RoleQueryResult> data = roleQueryService.getAllRole();
        model.addAttribute("data", data);
        return "rbac/role/index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        return "rbac/role/add";
    }

    @RequestMapping("/doAdd")
    public @ResponseBody String doAdd(Model model, Role role) {
        // 参数校验
        AjaxResult checkResult = RoleParamChecker.checkParam(role);
        if (checkResult != null) {
            return ajaxResult(checkResult);
        }
        JondaRbacUtil.setDataOperateInfo(role);
        roleManageService.addRole(role);
        AjaxResult ajaxResult = new AjaxResult("navTab_rbac_role", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/modify")
    public String modify(Model model, Long id) {
        RoleQueryResult data = roleQueryService.getRoleById(id);
        if (data == null) {
            throw new RuntimeException("修改数据不存在!");
        }
        model.addAttribute("data",data);
        return "rbac/role/modify";
    }

    @RequestMapping("/doModify")
    public @ResponseBody String doModify(Model model, Role role) {
        // 参数校验
        AjaxResult checkResult = RoleParamChecker.checkParam(role, Boolean.TRUE);
        if (checkResult != null) {
            return ajaxResult(checkResult);
        }
        JondaRbacUtil.setDataOperateInfo(role, Boolean.TRUE);
        roleManageService.modifyRole(role);
        AjaxResult ajaxResult = new AjaxResult("navTab_rbac_role", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/delete")
    public @ResponseBody String delete(Model model, Long id) {
        AjaxResult ajaxResult;
        if (id == null) {
            ajaxResult = new AjaxResult(StatusCodeEnum.ERROR, "操作失败");
            return ajaxResult(ajaxResult);
        }
        roleManageService.deleteRole(id);
        ajaxResult = new AjaxResult("navTab_rbac_role", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/distributeDialog")
    public String distributeDialog(Model model, Long roleId) {
        List<PermissionQueryResult> data = permissionQueryService.getAllPermission();
        List<Long> hasPermissionIds = permissionQueryService.getPermissionIdByRoleId(roleId);
        if (hasPermissionIds == null) {
            hasPermissionIds = new ArrayList<Long>();
        }
        model.addAttribute("hasPermissionIds", hasPermissionIds);
        if (hasPermissionIds.size() == data.size()) {
            model.addAttribute("checkAll", Boolean.TRUE);
        }
        model.addAttribute("data", data);
        model.addAttribute("roleId", roleId);
        return "rbac/role/distributePermissionDialog";
    }

    @RequestMapping("/distributePermission")
    public @ResponseBody String distributePermission(Model model, String roleId, HttpServletRequest request) {
        AjaxResult ajaxResult;
        String[] object = request.getParameterValues("permissionIds");
        if (object == null || object.length < 1) {
            ajaxResult = new AjaxResult(StatusCodeEnum.ERROR, "操作失败,请至少选择一条权限记录!");
            return ajaxResult(ajaxResult);
        }
        List<Long> permissionIds = new ArrayList<Long>();
        for (String permissionId : object) {
            if (StringUtils.isNumeric(permissionId)) {
                permissionIds.add(Long.valueOf(permissionId));
            }
        }
        if (permissionIds.size() < 1 || !StringUtils.isNumeric(roleId)) {
            ajaxResult = new AjaxResult(StatusCodeEnum.ERROR, "操作失败,系统发生错误，请联系管理员!");
            return ajaxResult(ajaxResult);
        }
        roleManageService.distributePermission(Long.valueOf(roleId), permissionIds);
        ajaxResult = new AjaxResult("navTab_rbac_role", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

}
