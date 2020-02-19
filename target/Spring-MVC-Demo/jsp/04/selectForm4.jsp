<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/19
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试select标签</title>
</head>
<body>
<h3>使用form:options标签绑定Object</h3>
<form:form modelAttribute="user" method="post" action="/04/selectForm">
    <table>
        <tr>
            <td>部门：</td>
            <td>
                <form:select path="deptId">
                    <form:options items="${deptList}" itemLabel="name" itemValue="id"/>
                </form:select>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
