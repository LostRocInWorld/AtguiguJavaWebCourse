<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/25
  Time: 上午 01:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${pageContext} <%--org.apache.jasper.runtime.PageContextImpl@73ae2961--%>
${pageContext.servletContext}

<%--request.getScheme()获取请求的协议--%>
<%=request.getScheme()%><br/>
<%--request.getServerName()获取服务器ip--%>
<%=request.getServerName()%><br/>
<%--request.getServerName()获取服务器端口号--%>
<%=request.getServerPort()%><br/>
<%--request.getContextPath()获取当前工程路径--%>
<%=request.getContextPath()%><br/>
<%--request.getMethod()获取请求的方法--%>
<%=request.getMethod()%><br/>
<%--request.getRemoteHost()获取客户端的ip--%>
<%=request.getRemoteHost()%><br/>
<%--request.getRequestedSessionId()获取会话的id编号--%>
<%=session.getId()%><br/>
<hr/>
1. 协议：
${pageContext.request.scheme}<br/>
2. 服务器ip：
${pageContext.request.serverName}<br/>
3. 服务器端口号：
${pageContext.request.serverPort}<br/>
4. 获取工程路径：
${pageContext.request.contextPath}<br/>
5. 获取请求方法：
${pageContext.request.method}<br/>
6. 获取客户端ip地址：
${pageContext.request.remoteHost}<br/>
7. 获取会话的id编号：
${pageContext.session.id}<br/>

<hr>
小技巧(企业常用)
<%
    pageContext.setAttribute("req",request);
%>
获取客户端ip地址：${req.remoteHost}
</body>
</html>
