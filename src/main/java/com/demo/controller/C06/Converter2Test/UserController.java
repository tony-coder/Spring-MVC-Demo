package com.demo.controller.C06.Converter2Test;

import com.demo.converter.DateEditor;
import com.demo.domain.C06.ConverterTest.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller("UserController11")
@RequestMapping(value = "/06/2")
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName) {
        // 动态跳转页面
        return "forward:/jsp/06/" + formName + ".jsp";
    }

    // 在控制器初始化时注册属性编辑器
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 注册自定义编辑器
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, Model model) {
        logger.info(user);
        model.addAttribute("user", user);
        return "/06/success";
    }
}