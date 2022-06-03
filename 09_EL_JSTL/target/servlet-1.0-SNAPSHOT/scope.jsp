<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/25
  Time: 上午 01:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("key1","pageContext1");
    pageContext.setAttribute("key2","pageContext2");
    request.setAttribute("key2","request2");
    session.setAttribute("key2","session2");
    application.setAttribute("key2","application2");

%>
${pageContext.key1}
${requestScope.key2}
${applicationScope.key2}
</body>
</html>
