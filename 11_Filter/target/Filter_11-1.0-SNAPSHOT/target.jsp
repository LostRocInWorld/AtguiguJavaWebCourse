<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/7/7
  Time: 上午 03:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("目标资源的线程"+Thread.currentThread().getName());
    System.out.println("target.jsp的request域中username参数："+request.getParameter("username"));
    System.out.println("target.jsp的取Filter1保存的参数user："+request.getAttribute("user"));

    System.out.println("target.jsp頁面執行了");
%>
  target.jsp页面执行了
</body>
</html>
