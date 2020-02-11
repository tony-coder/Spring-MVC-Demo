package com.demo.controller.C03.ModelAttributeTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 注意，被@ModelAttribute 注释的方法会在Controller每一个方法执行前被执行，因此再一个Controller映射到多个URL时，要谨慎使用
 *
 * 测试@ModelAttribute(value="")注释返回具体类的方法
 */

@Controller
@RequestMapping(value = "/ModelAttributeTest")
public class ModelAttribute1Controller {
    // 使用@ModelAttribute注释的value属性，来指定model属性的名称,model属性对象就是方法的返回值
    // @ModelAttribute注解只支持一个属性value，类型为String，表示绑定的属性名称
    // 被@ModelAttribute注解的userModel1的方法会优先于login1调用，它把请求参数loginname的值赋给loginname变量，并设置了一个属性loginname到Model当中
    @ModelAttribute("loginname")
    public String userModel1(@RequestParam("loginname") String loginname) {
        return loginname;
    }

    @RequestMapping(value = "/login1")
    public String login1(Model model) {
        //System.out.println((String) model.asMap().get("loginname"));
        return "result1";
    }

}