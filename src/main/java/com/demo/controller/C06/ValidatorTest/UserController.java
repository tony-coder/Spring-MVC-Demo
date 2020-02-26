package com.demo.controller.C06.ValidatorTest;

import com.demo.domain.C06.ValidatorTest.User;
import com.demo.validator.C06.UserValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("UserController13")
@RequestMapping(value = "/06/5")
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);

    // 注入UserValidator对象
    @Autowired
    @Qualifier("userValidator")
    private UserValidator userValidator;

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        // 动态跳转页面
        return "forward:/jsp/06/" + formName + ".jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, Model model, Errors errors) {
        logger.info(user);
        model.addAttribute("user", user);
        // 调用userValidator的验证方法
        userValidator.validate(user, errors);
        // 如果验证不通过跳转到loginForm视图
        if (errors.hasErrors()) {
            return "forward:/jsp/06/loginForm.jsp";
        }
        return "/06/success3";
    }

}
