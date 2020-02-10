<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/5
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试@RequestMapping注解</title>
</head>
<body>
<!-- 页面可以访问Controller传递传递出来的模型User对象 -->
欢迎[${requestScope.user.username }]登陆
<br>
访问request作用范围域中的user对象：${requestScope.user.username }<br>
访问session作用范围域中的user对象：${sessionScope.user.username }<br>

<br>
</body>
</html>
