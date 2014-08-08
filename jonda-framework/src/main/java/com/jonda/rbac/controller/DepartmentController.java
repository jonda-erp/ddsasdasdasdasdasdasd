package com.jonda.rbac.controller;

import com.jonda.common.spring.web.BaseController;
import com.jonda.rbac.dto.result.DepartmentQueryResult;
import com.jonda.rbac.service.DepartmentQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rejoady on 2014/7/25.
 */
@Controller
@RequestMapping("/rbac/department")
public class DepartmentController extends BaseController {

    @Resource
    private DepartmentQueryService departmentQueryService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<DepartmentQueryResult> data = departmentQueryService.getAllDepartment();
        model.addAttribute("data", data);
        return "rbac/department/index";
    }

    @RequestMapping("/dialog")
    public String dialog(Model model) {
        List<DepartmentQueryResult> data = departmentQueryService.getAllDepartment();
        model.addAttribute("data", data);
        return "rbac/department/dialog";
    }

}
