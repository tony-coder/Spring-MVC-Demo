package com.demo.controller.C03.DataBindingTest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller注解用于指示该类是一个控制器，可以同时处理多个请求动作
@Controller
public class DataBindingController {
    // 静态的日志类 LogFactory
    private static final Log logger = LogFactory.getLog(DataBindingController.class);

    // 测试@PathVariable注解
    // 该方法映射的请求为http://localhost:8080/DataBindingTest/pathVariableTest/{userId}
    // 它会将请求路径"/pathVariableTest/{userId}"中userId的值设置到方法参数userId变量当中
    @RequestMapping(value = "/pathVariableTest/{userId}")
    public void pathVariableTest(@PathVariable Integer userId) {
        logger.info("通过@PathVariable获得数据： " + userId);
    }

    // 测试@RequestHeader注解
    // 该方法映射的请求为http://localhost:8080/DataBindingTest/requestHeaderTest
    // 它会将请求头"User-Agent"的值赋值到userAgent变量上，并将"Accept"请求头的值赋到accepts参数上
    @RequestMapping(value = "/requestHeaderTest")
    public void requestHeaderTest(
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader(value = "Accept") String[] accepts) {
        logger.info("通过@requestHeaderTest获得数据： " + userAgent);
        for (String accept : accepts) {
            logger.info(accept);
        }
    }

    // 测试@CookieValue注解
    // 它会将JSESSIONID值入参到sessionId参数上，defaultValue表示Cookie中没有JSESSIONID时默认为空
    @RequestMapping(value = "/cookieValueTest")
    public void cookieValueTest(@CookieValue(value = "JSESSIONID", defaultValue = "") String sessionId) {
        logger.info("通过@requestHeaderTest获得数据： " + sessionId);
    }

}
