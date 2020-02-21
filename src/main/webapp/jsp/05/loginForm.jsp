<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/21
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试基于浏览器请求的国际化</title>
</head>
<body>
<!-- 使用message标签来输出国际化信息 -->
<h3><spring:message code="title"/></h3>
<form:form modelAttribute="user" method="post" action="login">
    <table>
        <tr>
            <td><spring:message code="loginname"/></td>
            <td><form:input path="loginname"/></td>
        </tr>
        <tr>
            <td><spring:message code="password"/></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="<spring:message code="submit"/> "></td>
        </tr>
    </table>
</form:form>
</body>
</html>