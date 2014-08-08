package com.jonda.rbac.controller;

import com.jonda.common.dto.Page;
import com.jonda.common.spring.web.AjaxResult;
import com.jonda.common.spring.web.BaseController;
import com.jonda.common.spring.web.StatusCodeEnum;
import com.jonda.rbac.controller.checker.UserParamChecker;
import com.jonda.rbac.domain.User;
import com.jonda.rbac.dto.param.UserQueryParam;
import com.jonda.rbac.dto.result.RoleQueryResult;
import com.jonda.rbac.dto.result.UserQueryResult;
import com.jonda.rbac.service.RoleQueryService;
import com.jonda.rbac.service.UserManageService;
import com.jonda.rbac.service.UserQueryService;
import com.jonda.rbac.shiro.JondaRbacUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rejoady on 2014/7/25.
 */
@Controller
@RequestMapping("/rbac/user")
public class UserController extends BaseController {

    @Resource
    private UserQueryService userQueryService;

    @Resource
    private UserManageService userManageService;

    @Resource
    private RoleQueryService roleQueryService;

    @RequestMapping("/index")
    public String index(Model model, UserQueryParam param,
                        @RequestParam(value = "department.id", required = false)Long departmentId,
                        @RequestParam(value = "department.name", required = false)String departmentName) {
        if (departmentId != null) {
            param.setDepartmentId(departmentId);
        }

        Page<UserQueryResult> page = userQueryService.queryUser(param);
        model.addAttribute("page", page);
        model.addAttribute("param", param);
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("departmentName", departmentName);
        return "rbac/user/index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        return "rbac/user/add";
    }

    @RequestMapping("/doAdd")
    public @ResponseBody String doAdd(Model model, User user, String repPassword) {
        // 参数校验
        AjaxResult checkResult = UserParamChecker.checkParam(user);
        if (checkResult != null) {
            return ajaxResult(checkResult);
        }
        JondaRbacUtil.setDataOperateInfo(user);
        userManageService.addUser(user);
        AjaxResult ajaxResult = new AjaxResult("navTab_rbac_user", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/modify")
    public String modify(Model model, Long id) {
        UserQueryResult data = userQueryService.getUserById(id);
        if (data == null) {
            throw new RuntimeException("修改数据不存在!");
        }

        model.addAttribute("data",data);
        return "rbac/user/modify";
    }

    @RequestMapping("/doModify")
    public @ResponseBody String doModify(Model model, User user) {
        // 参数校验
        AjaxResult checkResult = UserParamChecker.checkParam(user, Boolean.TRUE);
        if (checkResult != null) {
            return ajaxResult(checkResult);
        }
        JondaRbacUtil.setDataOperateInfo(user, Boolean.TRUE);
        userManageService.modifyUser(user);
        AjaxResult ajaxResult = new AjaxResult("navTab_rbac_user", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/modifyPassword")
    public String modifyPassword(Model model, Long id) {
        UserQueryResult data = userQueryService.getUserById(id);
        if (data == null) {
            throw new RuntimeException("修改数据不存在!");
        }

        model.addAttribute("data",data);
        return "rbac/user/modifyPassword";
    }

    @RequestMapping("/doModifyPassword")
    public @ResponseBody String doModifyPassword(Model model, User user, String repPassword) {
        // 参数校验
        AjaxResult checkResult = UserParamChecker.checkParam(user, Boolean.TRUE, Boolean.TRUE);
        if (checkResult != null) {
            return ajaxResult(checkResult);
        }
        JondaRbacUtil.setDataOperateInfo(user, Boolean.TRUE);
        userManageService.modifyPassword(user);
        AjaxResult ajaxResult = new AjaxResult("navTab_rbac_user", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/delete")
    public @ResponseBody String delete(Model model, Long id) {
        AjaxResult ajaxResult;
        if (id == null) {
            ajaxResult = new AjaxResult(StatusCodeEnum.ERROR, "操作失败");
            return ajaxResult(ajaxResult);
        }
        userManageService.deleteUser(id);
        ajaxResult = new AjaxResult("navTab_rbac_user", "操作成功！");
        return ajaxResult(ajaxResult);
    }

    @RequestMapping("/distributeDialog")
    public String distributeDialog(Model model, Long userId) {
        List<RoleQueryResult> data = roleQueryService.getAllRole();
        List<Long> hasRoleIds = roleQueryService.getRoleByUserId(userId);
        if (hasRoleIds == null) {
            hasRoleIds = new ArrayList<Long>();
        }
        model.addAttribute("hasRoleIds", hasRoleIds);
        if (hasRoleIds.size() == data.size()) {
            model.addAttribute("checkAll", Boolean.TRUE);
        }
        model.addAttribute("data", data);
        model.addAttribute("userId", userId);
        return "rbac/user/distributeRoleDialog";
    }

    @RequestMapping("/distributeRole")
    public @ResponseBody String distributePermission(Model model, String userId, HttpServletRequest request) {
        AjaxResult ajaxResult;
        String[] object = request.getParameterValues("roleIds");
        if (object == null || object.length < 1) {
            ajaxResult = new AjaxResult(StatusCodeEnum.ERROR, "操作失败,请至少选择一条角色记录!");
            return ajaxResult(ajaxResult);
        }
        List<Long> roleIds = new ArrayList<Long>();
        for (String roleId : object) {
            if (StringUtils.isNumeric(roleId)) {
                roleIds.add(Long.valueOf(roleId));
            }
        }
        if (roleIds.size() < 1 || !StringUtils.isNumeric(userId)) {
            ajaxResult = new AjaxResult(StatusCodeEnum.ERROR, "操作失败,系统发生错误，请联系管理员!");
            return ajaxResult(ajaxResult);
        }
        userManageService.distributeRole(Long.valueOf(userId), roleIds);
        ajaxResult = new AjaxResult("navTab_rbac_user", "closeCurrent", "操作成功！");
        return ajaxResult(ajaxResult);
    }

}
