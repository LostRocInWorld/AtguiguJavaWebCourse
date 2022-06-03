<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/24
  Time: 上午 04:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("key","value");
%>
<%="設置了key的值為value"%>
jsp表达式脚本输出key的值时:<%=request.getAttribute("key")%><br/>
EL表达式输出key的值是:${key}<br/>

jsp表达式脚本输出key1的值时:<%=request.getAttribute("key1")%><br/><%--輸出null--%>
EL表达式输出key1的值是:${key1}<br/>
</body>
</html>
