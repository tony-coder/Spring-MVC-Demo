package com.demo.converter;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

import java.util.Date;

// 实现WebBindingInitializer接口
public class DateBindingInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder webDataBinder) {
        // 注册自定义编辑器
        webDataBinder.registerCustomEditor(Date.class, new DateEditor());
    }
}
