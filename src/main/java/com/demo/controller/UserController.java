package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    // 映射url: http://localhost:8080/user/register
    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    // 映射url: http://localhost:8080/user/login
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    // 如果需要访问HttpServletRequest对象，则可以添加HttpServletRequest作为参数，Spring会将对象正确地传递给方法
    public String login(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }
}
