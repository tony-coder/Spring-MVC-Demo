package com.demo.controller.C06.JSR303Test;

import com.demo.domain.C06.JSR303Test.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller("UserController15")
@RequestMapping(value = "/06/6")
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        // 动态跳转页面
        return "forward:/jsp/06/" + formName + ".jsp";
    }

    // 数据校验使用@Valid，后面跟着Errors对象保存校验信息
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute User user, Errors errors, Model model) {
        logger.info(user);
        if (errors.hasErrors()) {
            return "forward:/jsp/06/registerForm4.jsp";
        }
        model.addAttribute("user", user);
        return "/06/success4";
    }

}
