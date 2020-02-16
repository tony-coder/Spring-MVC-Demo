package com.demo.controller.C03.JsonResponseTest;

import com.demo.domain.C03.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例：返回Json格式的数据
 */

@Controller
@RequestMapping(value = "/json")
public class BookController2 {
    @RequestMapping(value = "/testResponseBody")
    @ResponseBody
    public Object getJson() {
        List<Book> list = new ArrayList<Book>();
        list.add(new Book(1, "Spring MVC企业应用实战", "肖文吉"));
        list.add(new Book(2, "轻量级JavaEE企业应用实战", "李刚"));
        return list;
    }
}
