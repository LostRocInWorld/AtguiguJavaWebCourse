<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/7/7
  Time: 上午 01:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>这是登陆界面login.jsp</h1>
<form method="get" action="http://localhost:8080/Filter_11/loginServlet">
   用户名： <input type="text" name="username" /><br/>
   密码： <input type="password" name="password" /><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
