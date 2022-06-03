  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/24
  Time: 上午 02:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 600px;
            border-top-width: 0px;
            border-right-width: 0px;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>九九乘法表</h1>
<table border="1px" align="center" cellspacing="0">
    <%
        for (int i = 0; i <= 9; i++) {%>
    <tr>
        <% for (int j = 1; j <= i; j++) {%>
        <td><%=i + "x" + j + "=" + (i * j)%>
        </td>
        <%}%>
        <%}%>
    </tr>
</table>
</body>
</html>
