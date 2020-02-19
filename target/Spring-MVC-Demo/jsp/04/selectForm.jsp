<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/19
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试select标签</title>
</head>
<body>
<h3>form:select标签直接添加form:option</h3>
<form:form modelAttribute="user" method="post" action="04/selectForm">
    <table>
        <tr>
            <td>部门</td>
            <td>
                <form:select path="deptId">
                    <form:option value="1">财务部</form:option>
                    <form:option value="2">开发部</form:option>
                    <form:option value="3">销售部</form:option>
                </form:select>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
