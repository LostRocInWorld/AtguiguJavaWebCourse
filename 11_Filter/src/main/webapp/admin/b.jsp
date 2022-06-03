<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/7/7
  Time: 上午 01:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("b.jsp页面执行了");
    Object user = session.getAttribute("user");
    //如果等于null，说明还没有登陆
    if(user == null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return;
    }
%>
<h1>我是b.jsp页面</h1>
</body>
</html>
