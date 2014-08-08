package com.jonda.rbac.controller;

import com.jonda.common.spring.web.BaseController;
import com.jonda.rbac.service.UserManageService;
import com.jonda.rbac.util.ValidateCodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by rejoady on 2014/7/20.
 */
@Controller
@RequestMapping("/rbac")
public class LoginController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserManageService userManageService;

    /**
     * 访问用户登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String index() {
        System.out.println("访问登录页面");
        return "rbac/login";
    }

    /**
     * 获取图片验证码
     */
    @RequestMapping("/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) {
        String checkCode = ValidateCodeUtil.getCode();
        request.getSession().setAttribute(ValidateCodeUtil.VALIDATE_CODE_KEY,checkCode);

        BufferedImage buffImg = ValidateCodeUtil.generateImage(checkCode);

        // 写图片
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = null;
        try {
            //获取输出流对象
            sos = response.getOutputStream();
            //写图片的二进制流
            ImageIO.write(buffImg, "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            logger.warn("返回验证码图片出错,"+e.getMessage()) ;
        } finally {
            if(sos != null) {
                try {
                    //关闭输出流
                    sos.close() ;
                } catch (IOException e) {
                    logger.warn("关闭输出流出错,"+e.getMessage()) ;
                }
            }
        }
    }

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(Model model, String loginName, String password, String checkCode, HttpServletRequest request) {
        // 获取session中保存的验证码
        Object sessionCheckCodeObject = request.getSession().getAttribute(ValidateCodeUtil.VALIDATE_CODE_KEY);
        String sessionCheckCode = null;
        if (sessionCheckCodeObject != null) {
            sessionCheckCode = sessionCheckCodeObject.toString();
        }

        // 检查用户名是否为空
        if (StringUtils.isBlank(loginName)) {
            addFieldMessage(model, "loginName", "用户名不能为空");
        }

        // 检查密码
        if (StringUtils.isBlank(password)) {
            addFieldMessage(model, "password", "密码不能为空");
        }
        // 检查验证码
        if (StringUtils.isBlank(checkCode)) {
            addFieldMessage(model, "checkCode", "验证码不能为空");
        } else {
            if (sessionCheckCode == null || !sessionCheckCode.toLowerCase().equals(checkCode.toLowerCase())) {
                logger.info("验证码错误");
                addFieldMessage(model, "checkCode", "验证码输入错误");
            }
        }

        if (hasMessages(model)) {
            //登录失败，返回登录页
            logger.info("用户 [{}] 登录失败！", loginName);
            return "rbac/login";
        }

        try {
            // 进行登录验证
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, password, Boolean.TRUE);
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            addActionMessage(model, "用户名或密码错误");
            logger.info("用户登录失败，message:{}", e.getMessage(), e);
        }

        if (hasMessages(model)) {
            //登录失败，返回登录页
            logger.info("用户 [{}] 登录失败！", loginName);
            return "rbac/login";
        } else {
            //登录成功，返回主页
            logger.info("用户 [{}] 登录成功！", loginName);
            return "redirect:/";
        }
    }

    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/";
    }
}
