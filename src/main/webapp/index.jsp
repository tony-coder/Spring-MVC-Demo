<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
</head>
<body>
<h2>Hello World</h2>
<a href="helloworld">Hello World</a>

<h2>注册、登录</h2>
<a href="user/register">注册</a><br><br>

<h2>数据绑定测试</h2>
<a href="pathVariableTest/1">测试@PathVariable注解</a><br><br>
<a href="requestHeaderTest">测试@RequestHeader注解</a><br><br>
<a href="cookieValueTest">测试@CookieValue注解</a><br><br>

<h2>测试@ModelAttribute的不同用法</h2>
<a href="loginForm1">测试@ModelAttribute(value="")注释返回具体类的方法 </a><br><br>
<a href="loginForm2">测试@ModelAttribute注释void返回值的方法</a><br><br>
<a href="loginForm3">测试@ModelAttribute注释返回具体类的方法</a><br><br>
<a href="loginForm4">测试@ModelAttribute和@RequestMapping同时注释一个方法 </a><br><br>
<a href="loginForm5">测试@ModelAttribute注释一个方法的参数 </a><br><br>

<h2>接收JSON格式的数据</h2>
<a href="jsonRequestTest">测试接收JSON格式的数据</a><br><br>

<h2>返回JSON格式的数据</h2>
<a href="jsonResponseTest">测试返回JSON格式的数据</a><br><br>

<h2>form和input标签的使用</h2>
<a href="04/registerForm">注册</a>
<p>
    发送到控制器UserController，将uer设置到model当中，属性名为"command"，然后将请求转发到/04/registerForm.jsp，
    这时如果Model中存在一个属性名称为command的javaBean，而且拥有属性username、sex、age，则在渲染上面的代码会取出command对应的属性，
    赋给对应标签的属性
</p>
<br>
<a href="04/registerForm2">注册</a>
<p>
    SpringMVC 指定form标签默认自动绑定的是Model的command属性值，那么当from对象对应的属性不是command时，
    可以使用commandName属性或modelAttribute指定Model哪个属性作为from标签需要绑定的command对象
</p>
<br>

<h2>checkbox标签的使用</h2>
<a href="04/checkboxForm">选择</a>
<br><br>

<h2>checkboxes标签的使用</h2>
<a href="04/checkboxesForm">选择</a>
<p>checkboxes呈现出的标签Label和其值相同</p>

<a href="04/checkboxesForm2">选择</a>
<p>checkboxes呈现出来的Label和value不同 使用map</p>

<a href="04/checkboxesForm3">选择</a>
<p>
    当使用Array或者集合作为数据源，且里面的元素都是一个domain对象时，还可以使用checkboxes标签的itemLabel和itemValue属性来表示，
    使用数组或者集合中元素对象的哪一个属性作为需要呈现的单选框的label和value
</p>

</body>
</html>
