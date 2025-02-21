package com.demo.controller.C03.ModelAttributeTest;

import com.demo.domain.C03.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试@ModelAttribute注释一个方法的参数
 */

@Controller
@RequestMapping(value = "/ModelAttributeTest")
public class ModelAttribute5Controller {
    // model属性名称就是value值即”user”，model属性对象就是方法的返回值
    @ModelAttribute("user")
    public User userModel5(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password) {
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        return user;
    }

    // @ModelAttribute("user") User user注释方法参数，参数user的值来源于userModel5()方法中的model属性。
    @RequestMapping(value = "/login5")
    public String login5(@ModelAttribute("user") User user) {
        user.setUsername("admin");
        return "result5";
    }

}
