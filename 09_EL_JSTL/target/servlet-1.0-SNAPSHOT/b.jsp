<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/24
  Time: 下午 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //往四个域中都保存了相同key的数据
//    pageContext.setAttribute("key","pageContext");
//    request.setAttribute("key","request");
//    session.setAttribute("key","session");    //注意浏览器未关闭，session中key的值仍然存在
    application.setAttribute("key","application");
%>
${key}
</body>
</html>
