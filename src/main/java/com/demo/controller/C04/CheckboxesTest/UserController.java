package com.demo.controller.C04.CheckboxesTest;

import com.demo.domain.C04.CheckboxesTest.Dept;
import com.demo.domain.C04.CheckboxesTest.Employee;
import com.demo.domain.C04.CheckboxesTest.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("UserController4")
@RequestMapping("/04")
public class UserController {
    @RequestMapping(value = "/checkboxesForm", method = RequestMethod.GET)
    public String registerForm(Model model) {
        User user = new User();
        // 为集合变量courses添加“JAVAEE”和“Spring”，页面的checkbox复选框这两项会被选中
        List<String> list = new ArrayList<>();
        list.add("JAVAEE");
        list.add("Spring");
        user.setCourses(list);
        // 页面展现的可供选择的复选框内容courseList
        List<String> courseList = new ArrayList<>();
        courseList.add("JAVAEE");
        courseList.add("Mybatis");
        courseList.add("Spring");
        // model中添加属性user和courseList
        model.addAttribute("user", user);
        model.addAttribute("courseList", courseList);
        return "forward:/jsp/04/checkboxesForm.jsp";
    }

    // 让checkboxes呈现出来的Label和value不同
    @RequestMapping(value = "/checkboxesForm2", method = RequestMethod.GET)
    public String registerForm2(Model model) {
        User user = new User();
        // 为集合变量courses添加“JAVAEE”和“Spring”，页面的checkbox复选框这两项会被选中
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        user.setCourses(list);
        // 页面展现的可供选择的复选框内容courseList
        Map<String, String> courseMap = new HashMap<>();
        courseMap.put("1", "JAVAEE");
        courseMap.put("2", "Mybatis");
        courseMap.put("3", "Spring");
        // model中添加属性user和courseList
        model.addAttribute("user", user);
        model.addAttribute("courseMap", courseMap);
        return "forward:/jsp/04/checkboxesForm2.jsp";
    }

    // 当使用Array或者集合作为数据源，且里面的元素都是一个domain对象时，还可以使用checkboxes标签的itemLabel和itemValue属性来表示
    @RequestMapping(value = "/checkboxesForm3", method = RequestMethod.GET)
    public String registerForm3(Model model) {
        Employee employee = new Employee();
        Dept dept = new Dept(1, "开发部");
        // 为集合变量depts添加Dept对象，该对象id=1，name=开发吧，页面的checkbox复选框这一项会被选中
        List<Dept> list = new ArrayList<>();
        list.add(dept);
        employee.setDepts(list);
        // 页面展现的可供选择的复选框内容deptList
        List<Dept> deptList = new ArrayList<>();
        deptList.add(dept);
        deptList.add(new Dept(2, "销售部"));
        deptList.add(new Dept(3, "财务部"));
        // model中添加属性employee和deptList
        model.addAttribute("employee", employee);
        model.addAttribute("deptList", deptList);
        return "forward:/jsp/04/checkboxesForm3.jsp";
    }

}
