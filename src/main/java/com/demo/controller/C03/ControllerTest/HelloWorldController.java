package com.demo.controller.C03.ControllerTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    @RequestMapping("/helloworld")
    public String helloworld(Model model) {
        model.addAttribute("message", "Hello World");
        return "helloWorld";
    }
}
