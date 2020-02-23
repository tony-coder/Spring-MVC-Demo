package com.demo.controller.C06.ConverterTest;

import com.demo.domain.C06.ConverterTest.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("UserController10")
@RequestMapping(value = "/06")
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName) {
        // 动态跳转页面
        return "forward:/jsp/06/" + formName + ".jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, Model model) {
        logger.info(user);
        model.addAttribute("user", user);
        return "06/success";
    }
}
