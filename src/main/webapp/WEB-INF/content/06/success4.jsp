<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/27
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试JSR 303</title>
</head>
<body>
<h3>测试JSR 303</h3>
登录名：${requestScope.user.loginname }<br>
密码：${requestScope.user.password }<br>
用户名：${requestScope.user.username }<br>
年龄：${requestScope.user.age }<br>
邮箱：${requestScope.user.email }<br>
生日：<fmt:formatDate value="${requestScope.user.birthday}" pattern="yyyy年MM月dd日"/><br>
电话：${requestScope.user.phone }<br>
</body>
</html>