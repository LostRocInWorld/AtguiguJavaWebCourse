<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/25
  Time: 上午 03:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>&lt;c:set/&gt;标签</h1>
    保存之前key为abc的值：${requestScope.abc}<br/>
    <c:set scope="page" var="abc" value="abcValue"/>
    保存之后key为abc的值：${pageScope.abc}<br/>
    <hr/>
    <h1>&lt;c:if/&gt;标签</h1>
    <c:if test="${12 != 12}">
        <h2>12不等于12</h2>
    </c:if>
    <c:if test="${12 == 12}">
        <h2>12等于12</h2>
    </c:if>
    <hr/>
    <h1>&lt;c:choose&gt;&lt;c:when&gt;&lt;c:oherwise&gt;标签</h1>
    <c:set scope="request" var="height" value="178"/>
    <c:choose >
        <c:when test="${requestScope.height>190}">
            <h2>小巨人</h2>
        </c:when>
        <c:when test="${requestScope.height>180}">
            <h2>很高</h2>
        </c:when>
        <c:when test="${requestScope.height>170}">
            <h2>还可以</h2>
        </c:when>
        <c:otherwise>
            <h2>小于170的靓仔</h2>
        </c:otherwise>
    </c:choose>


</body>
</html>
