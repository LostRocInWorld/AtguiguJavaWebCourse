<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/23
  Time: 下午 09:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>这是scope2.jsp页面</h1><br/>

pageContext域是否有值：<%=pageContext.getAttribute("key")%><br/>
request域是否有值：<%=request.getAttribute("key")%><br/>
session域是否有值：<%=session.getAttribute("key")%><br/>
application域是否有值：<%=application.getAttribute("key")%><br/>
</body>
</html>
