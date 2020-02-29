<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/29
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  //获取web应用根目录路径
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <style type="text/css">
        table {
            border-collapse: collapse;
            border-spacing: 0;
            border-left: 1px solid #888;
            border-top: 1px solid #888;
            background: #efefef;
        }

        th, td {
            border-right: 1px solid #888;
            border-bottom: 1px solid #888;
            padding: 5px 15px;
        }

        th {
            font-weight: bold;
            background: #ccc;
        }
    </style>
</head>
<body>
<h3>欢迎[${sessionScope.user.username }]访问</h3>
<br>
<table border="1">
    <tr>
        <th>封面</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
    </tr>
    <c:forEach items="${requestScope.book_list }" var="book">
        <tr>
            <td><img src="<%=basePath%>images/${book.image }" height="60"></td>
            <td>${book.name }</td>
            <td>${book.author }</td>
            <td>${book.price }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>