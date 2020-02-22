package com.demo.controller.C05.I18N3Test;

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
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller("UserController9")
@RequestMapping(value = "/05/3")
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/{formName}")
    public String loginForm(
            @PathVariable String formName,
            String request_locale,
            Model model,
            HttpServletRequest request,
            HttpServletResponse response) {
        logger.info("request_locale = " + request_locale);
        if (request_locale != null) {
            if (request_locale.equals("zh_CN")) {
                Locale locale = new Locale("zh", "CN");
                (new CookieLocaleResolver()).setLocale(request, response, locale);
            } else if (request_locale.equals("en_US")) {
                Locale locale = new Locale("en", "US");
                (new CookieLocaleResolver()).setLocale(request, response, locale);
            } else {
                (new CookieLocaleResolver()).setLocale(request, response, LocaleContextHolder.getLocale());
            }
        }
        User user = new User();
        model.addAttribute("user", user);
        // 动态跳转页面
        return "forward:/jsp/05/" + formName + ".jsp";
    }

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
}
