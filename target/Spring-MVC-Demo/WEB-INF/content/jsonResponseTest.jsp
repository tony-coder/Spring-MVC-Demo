<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/13
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%-- 1. 页面使用jquery发送json数据，再页面的<head>部分，引入jquery和json2的js文件 --%>
<%-- 2. 载入页面时调用 testResponseBody 函数 --%>
<%-- 3. testResponseBody 函数发送异步请求到"json/testResponseBody"，请求成功将返回一个json数据，
该数据包含多个数据信息。接受到返回的数据后使用jquery将数据设置到页面的<table>表单中 --%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试返回JSON格式的数据</title>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/json2.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            testResponseBody();
        });

        function testResponseBody() {
            $.post("${pageContext.request.contextPath}/json/testResponseBody", null,
                function (data) {
                    $.each(data, function () {
                        var tr = $("<tr align='center'/>");
                        $("<td/>").html(this.id).appendTo(tr);
                        $("<td/>").html(this.name).appendTo(tr);
                        $("<td/>").html(this.author).appendTo(tr);
                        $("#booktable").append(tr);
                    })
                }, "json");
        }
    </script>
</head>
<body>
<table id="booktable" border="1" style="border-collapse: collapse;">
    <tr align="center">
        <th>编号</th>
        <th>书名</th>
        <th>作者</th>
    </tr>
</table>

</body>
</html>