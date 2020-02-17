<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/17
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试checkboxes标签</title>
</head>
<body>
<h3>form:checkboxes测试</h3>
<form:form modelAttribute="employee" method="post" action="04/checkboxesForm3">
    <table>
        <tr>
            <td>选择部门</td>
            <td>
                <form:checkboxes path="depts" items="${deptList}" itemLabel="name" itemValue="id"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
