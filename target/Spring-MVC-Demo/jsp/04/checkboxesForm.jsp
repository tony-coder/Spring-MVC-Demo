<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/17
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试checkboxes标签</title>
</head>
<body>
<h3>form:checkboxes测试</h3>
<form:form modelAttribute="user" method="post" action="checkboxesForm">
    <table>
        <tr>
            <td>选择课程：</td>
            <td>
                <%-- path:要绑定的属性路径；items:用于生成checkbox元素对象的Collection --%>
                <%-- path 决定选中元素；items 决定可供选择的复选框内容 --%>
                <form:checkboxes path="courses" items="${courseList}"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
