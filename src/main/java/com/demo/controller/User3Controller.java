package com.demo.controller;

import com.demo.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User3Controller 和 User1Controller 的代码功能基本一致，只是存储对象改成了ModelAndView
 */

public class User3Controller {
    private static final Log logger = LogFactory.getLog(User1Controller.class);

    @ModelAttribute
    public void userModel3(String loginname, String password, ModelAndView mv) {
        logger.info("userModel3");
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        // 将User对象添加到ModelAndView 的 Model 当中
        mv.addObject("user", user);
    }

    @RequestMapping(value = "/login3")
    public ModelAndView login3(ModelAndView mv) {
        logger.info("login3");
        User user = (User) mv.getModel().get("user");
        System.out.println(user);
        // 设置user对象的username属性
        mv.setViewName("result3");
        return mv;
    }
}
