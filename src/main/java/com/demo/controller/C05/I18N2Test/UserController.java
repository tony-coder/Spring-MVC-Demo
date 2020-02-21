package com.demo.controller.C05.I18N2Test;

import com.demo.domain.C05.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller("Controller8")
@RequestMapping(value = "/05")
public class UserController {
    private static final Log logger = LogFactory.getLog(com.demo.controller.C05.I18NTest.UserController.class);

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName, String request_locale, Model model, HttpServletRequest request) {
        logger.info("request_locale = " + request_locale);
        if (request_locale != null) {
            // 设置中文环境
            if (request_locale.equals("zh_CN")) {
                Locale locale = new Locale("zh", "CN");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
            }
            // 设置英文环境
            else if (request_locale.equals("en_US")) {
                Locale locale = new Locale("en", "US");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
            }
            // 使用之前的语言环境
            else {
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
            }
        }
        User user = new User();
        model.addAttribute("user", user);
        // 动态跳转页面
        return "forward:/jsp/05/" + formName + ".jsp";
    }

    // 可以直接使用之前样例定义的login方法
/*
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute @Validated User user,
                        Model model,
                        HttpServletRequest request) {
        logger.info(user);
        if(user.getLoginname()!=null && user.getLoginname().equals("admin")
                && user.getPassword()!=null && user.getPassword().equals("123456")){
            // 从后台代码获取国际化信息
            RequestContext requestContext = new RequestContext(request);
            String username = requestContext.getMessage("username");
            user.setUsername(username);
            model.addAttribute("user", user);
            return "success";
        }
        return "error";
    }
    */
}
