package com.demo.controller.C03.DataBindingTest;

import com.demo.domain.C03.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// 将Model中的属性名为user的放入HttpSession对象当中
// @SessionAttributes注解类型允许我们有选择的指定Model中的哪些属性需要转存到HttpSession对象当中
@SessionAttributes("user")
public class SessionAttributesController {
    // 静态的日志类 LogFactory
    private static final Log logger = LogFactory.getLog(DataBindingController.class);

    // 该方法映射的请求为http://localhost:8080/DataBindingTest/{formName}
    /*@RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName) {
        // 动态跳转页面
        return formName;
    }*/

    // 该方法映射的请求为http://localhost:8080/DataBindingTest/login
    @RequestMapping(value = "/login")
    public String login(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            Model model) {
        // 创建User对象，装载用户信息
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setUsername("admin");
        // 将user对象添加到Model当中
        model.addAttribute("user", user);
        return "welcome";
    }
}
