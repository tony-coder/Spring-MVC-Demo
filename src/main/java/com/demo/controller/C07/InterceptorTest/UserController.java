package com.demo.controller.C07.InterceptorTest;

import com.demo.domain.C07.InterceptorTest.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller("UserController16")
@RequestMapping(value = "/07")
public class UserController {
    @RequestMapping(value = "/login")
    public ModelAndView login(String loginname, String password, ModelAndView mv, HttpSession session) {
        // 模拟数据库根据登录名和密码查找用户，判断用户登录
        if (loginname != null && loginname.equals("admin") && password != null && password.equals("123456")) {
            // 模拟创建用户
            User user = new User();
            user.setLoginname(loginname);
            user.setPassword(password);
            user.setUsername("管理员");
            // 登录成功，将user对象设置到HttpSession作用范围域
            session.setAttribute("user", user);
            // 转发到main请求
            mv.setViewName("redirect:/07/main");
        } else {
            // 登录失败，设置失败提示信息，并跳转到登录页面
            mv.addObject("message", "登录名或密码错误，请重新输入!");
            mv.setViewName("forward:/jsp/07/loginForm.jsp");
        }
        return mv;
    }
}
