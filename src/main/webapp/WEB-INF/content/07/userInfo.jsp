<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/28
  Time: 16:08
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
    <title>文件下载</title>
</head>
<body>

<a href="<%=basePath%>07/download?filename=${requestScope.user.image.originalFilename}">${requestScope.user.image.originalFilename}</a>

</body>
</html>
