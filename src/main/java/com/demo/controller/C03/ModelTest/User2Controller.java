package com.demo.controller.C03.ModelTest;

import com.demo.domain.C03.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User2Controller 和 User1Controller的代码功能基本一致，只是存储对象由Model改成了ModelMap
 */
@Controller
@RequestMapping(value = "/ModelTest")
public class User2Controller {
    private static final Log logger = LogFactory.getLog(User1Controller.class);

    @ModelAttribute
    public void userMode2(String loginname, String password, ModelMap modelMap) {
        logger.info("userModel2");
        // 创建User对象存储jsp页面传入参数
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        // 将User对象添加到ModelMap当中
        modelMap.addAttribute("user", user);
    }

    @RequestMapping(value = "/login2")
    public String login2(ModelMap modelMap) {
        logger.info("login2");
        // 从ModelMap当中取出之前存入的名为user的对象
        User user = (User) modelMap.get("user");
        System.out.println(user);
        // 设置user对象的username属性
        user.setUsername("测试");
        return "result2";
    }
}
