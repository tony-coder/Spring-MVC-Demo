package com.demo.controller.C04.SelectTest;

import com.demo.domain.C04.SelectTest.Dept;
import com.demo.domain.C04.SelectTest.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("UserController5")
@RequestMapping("/04")
public class UserController {
    @RequestMapping(value = "/selectForm", method = RequestMethod.GET)
    public String selectForm(Model model) {
        User user = new User();
        // 设置deptId的值，页面的select下拉框对应的option项会被选中
        user.setDeptId(2);
        model.addAttribute("user", user);
        return "forward:/jsp/04/selectForm.jsp";
    }

    @RequestMapping(value = "/slelctForm2", method = RequestMethod.GET)
    public String selectForm2(Model model) {
        User user = new User();
        user.setDeptId(2);
        // 页面展现的可供选择的select下拉框内容deptMap
        Map<Integer, String> deptMap = new HashMap<>();
        deptMap.put(1, "财务部");
        deptMap.put(2, "开发部");
        deptMap.put(3, "销售部");
        model.addAttribute("user", user);
        model.addAttribute("deptMap", deptMap);
        return "forward:/jsp/04/selectForm2.jsp";
    }

    @RequestMapping(value = "/slelctForm3", method = RequestMethod.GET)
    public String selectForm3(Model model) {
        User user = new User();
        user.setDeptId(2);
        // 页面展现的可供选择的select下拉框内容deptMap
        Map<Integer, String> deptMap = new HashMap<>();
        deptMap.put(1, "财务部");
        deptMap.put(2, "开发部");
        deptMap.put(3, "销售部");
        model.addAttribute("user", user);
        model.addAttribute("deptMap", deptMap);
        return "forward:/jsp/04/selectForm3.jsp";
    }

    @RequestMapping(value = "/selectForm4", method = RequestMethod.GET)
    public String selectForm4(Model model) {
        User user = new User();
        user.setDeptId(2);
        // 页面展现的可供选择的select下拉框内容deptList，其中的元素的Dept对象
        // 模拟从数据库获取到部门信息封装到对象当中
        List<Dept> deptList = new ArrayList<>();
        deptList.add(new Dept(1, "财务部"));
        deptList.add(new Dept(2, "开发部"));
        deptList.add(new Dept(3, "销售部"));
        model.addAttribute("user", user);
        model.addAttribute("deptList", deptList);
        return "forward:/jsp/04/selectForm4.jsp";
    }
}
