<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/7/3
  Time: 下午 08:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="login" method="get">
        <%--cookie是EL表达式的隐含对象--%>
        用户名:<input type="text" name="username" value="${cookie.username.value}"/>
        密码:<input type="password" name="password" value=""/>
        <input type="submit" value="登陆"/>
    </form>
</body>
</html>
