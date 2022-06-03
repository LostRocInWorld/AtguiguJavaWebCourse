<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/24
  Time: 上午 01:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
头部信息<br/>
主体内容<br/>
<%--静态包含--%>
<%--<%@ include file="/includes/footer.jsp"%>--%>

<%--动态包含--%>
<jsp:include page="/includes/footer.jsp">
    <jsp:param name="username" value="user"/>
    <jsp:param name="password" value="123456"/>
</jsp:include>
</body>
</html>
