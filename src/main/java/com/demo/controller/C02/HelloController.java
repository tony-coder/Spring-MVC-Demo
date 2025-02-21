package com.demo.controller.C02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HelloController是一个实现Controller接口的控制器,
 * 可以处理一个单一的请求动作
 */
public class HelloController implements Controller {
    private static final Log logger = LogFactory.getLog(HelloController.class);

    /**
     * handleRequest是Controller接口必须实现的方法。
     * 该方法的参数是对应请求的HttpServletRequest和HttpServletResponse。
     * 该方法必须返回一个包含视图路径或视图路径和模型的ModelAndView对象。
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        logger.info("handleRequest 被调用");
        // 创建准备返回的ModelAndView对象，该对象通常包含了返回视图的路径、模型的名称以及模型对象
        ModelAndView mv = new ModelAndView();
        // 添加模型数据 可以是任意的POJO对象
        mv.addObject("message", "Hello World!");
        // 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        // 返回ModelAndView对象
        return mv;
    }
}
