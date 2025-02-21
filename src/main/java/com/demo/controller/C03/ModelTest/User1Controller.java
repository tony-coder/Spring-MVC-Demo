package com.demo.controller.C03.ModelTest;

import com.demo.domain.C03.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ModelAttribute 修饰的userModel方法会先于login调用，它把请求参数赋给对应变量，可以向方法中的Model添加对象，前提是要在方法签名
 * 中加入一个Model类型的参数
 */

@Controller
@RequestMapping(value = "/ModelTest")
public class User1Controller {
    private static final Log logger = LogFactory.getLog(User1Controller.class);

    // @ModelAttribute修饰的方法会先于login调用，该方法用于接管前台jsp页面传入的参数
    @ModelAttribute
    public void userModel(String loginname, String password, Model model) {
        logger.info("userModel");
        // 创建User对象存储jsp页面传入参数
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        // 将User对象添加到Model当中
        model.addAttribute("user", user);
    }

    @RequestMapping(value = "/login1")
    public String login(Model model) {
        logger.info("login");
        //从Model当中取出之前存入的名为user的对象
        User user = (User) model.asMap().get("user");
        System.out.println(user);
        // 设置user对象的username属性
        return "result1";
    }
}
