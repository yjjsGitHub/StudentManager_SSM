package com.yjj.controller;

import com.yjj.model.Admin;
import com.yjj.service.AdminService;
import com.yjj.service.KlassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/13.
 */
@Controller
public class AdminController {

    @Resource
    private AdminService adminService;
    @Resource
    private KlassService klassService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email == null || password == null) {
            model.addAttribute("msg", "账号或密码不能为空");
            return "login";
        } else {
            Admin admin = adminService.login(email, password);
            if (admin == null) {
                model.addAttribute("msg", "账号不存在");
                return "login";
            } else {
                request.getSession().setAttribute("email", email);
                request.getSession().setAttribute("lastTime", new Date(admin.getLastTime().getTime()));
                adminService.lastLogin(email);
                return "redirect:index";
            }
        }
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("email") == null) {
            //没登录
            model.addAttribute("msg", "您尚未登录或登录已失效");
            return "login";
        }
        model.addAttribute("lastTime", request.getSession().getAttribute("lastTime"));

        //将班级列表绑定到首页上
        model.addAttribute("classList", klassService.list());
        return "index";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        //注销登陆
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping(value = "/klassList")
    public String klassList(HttpServletRequest request, HttpServletResponse response, Model model) {
        if (request.getSession().getAttribute("email") == null) {
            //没登录
            model.addAttribute("msg", "您尚未登录或登录已失效");
            return "login";
        }
        //将班级列表绑定到首页上
        model.addAttribute("classList", klassService.list());
        return "klassList";
    }

    @RequestMapping(value = "/klassDelete")
    public String klassDelete(HttpServletRequest request, HttpServletResponse response, Model model) {
        if (request.getSession().getAttribute("email") == null) {
            //没登录
            model.addAttribute("msg", "您尚未登录或登录已失效");
            return "login";
        }
        //将班级列表绑定到首页上
        model.addAttribute("classList", klassService.list());
        return "klassDelete";
    }
}
