package com.demo.controller.C06.AnnotationFormatterTest;

import com.demo.domain.C06.AnnotationFormatterTest.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/06/4")
public class FormatterController {
    private static final Log logger = LogFactory.getLog(FormatterController.class);

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName) {
        //动态跳转页面
        return "forward:/jsp/06/" + formName + ".jsp";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@ModelAttribute User user, Model model) {
        logger.info(user);
        model.addAttribute("user", user);
        return "/06/success2";
    }
}
