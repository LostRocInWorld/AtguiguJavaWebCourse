<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/25
  Time: 上午 01:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map<String,Object> map = new HashMap<>();
    map.put("a.aa","aaaValue");
    map.put("b+bb","bbbValue");
    map.put("c/cc","cccValue");

    request.setAttribute("map",map);
%>
${map['a.aa']}
${map["b+bb"]}
${map["c/cc"]}
</body>
</html>
