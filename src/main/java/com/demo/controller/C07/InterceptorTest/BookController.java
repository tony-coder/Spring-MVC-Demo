package com.demo.controller.C07.InterceptorTest;

import com.demo.domain.C07.InterceptorTest.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller("BookController2")
@RequestMapping(value = "/07")
public class BookController {
    /**
     * 处理/main请求
     */
    @RequestMapping(value = "/main")
    public String main(Model model) {
        // 模拟数据库获得所有图书集合
        List<Book> book_list = new ArrayList<>();
        book_list.add(new Book("java.jpg", "疯狂Java讲义（附光盘）", "李刚 编著", 74.2));
        book_list.add(new Book("ee.jpg", "轻量级Java EE企业应用实战", "李刚 编著", 59.2));
        book_list.add(new Book("android.jpg", "疯狂Android讲义（附光盘）", "李刚 编著", 60.6));
        book_list.add(new Book("ajax.jpg", "疯狂Ajax讲义（附光盘）", "李刚 编著", 66.6));
        // 将图书集合添加到model当中
        model.addAttribute("book_list", book_list);
        // 跳转到main页面
        return "/07/main";
    }
}
