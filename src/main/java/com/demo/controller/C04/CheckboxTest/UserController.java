package com.demo.controller.C04.CheckboxTest;

import com.demo.domain.C04.CheckboxTest.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller("UserController3")
@RequestMapping("/04")
public class UserController {
    @RequestMapping(value = "/checkboxForm", method = RequestMethod.GET)
    public String registerForm(Model model) {
        User user = new User();
        // 设置boolean变量reader的值为true，页面的checkbox复选框会被选中
        user.setReader(true);
        // 为集合变量courses添加“JAVAEE”和“Spring”，页面的checkbox复选框这两项会被选中
        List<String> list = new ArrayList<>();
        list.add("JAVAEE");
        list.add("Spring");
        user.setCourses(list);
        // model中添加属性command，值是user对象
        model.addAttribute("user", user);
        return "forward:/jsp/04/checkboxForm.jsp";
    }

}
