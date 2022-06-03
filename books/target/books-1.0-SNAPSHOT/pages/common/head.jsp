<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/26
  Time: 下午 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--    使用base+相对路径  永远固定相对路径跳转的结果-->

<%
    //获取协议
    String basePath = request.getScheme()   //协议
            +"://"+request.getServerName()  //服务器ip
            +":"+request.getServerPort()    /*//服务器端口*/
            +request.getContextPath()   //工程路径
            +"/";   //注意这个斜杠
    pageContext.setAttribute("basePath",basePath);
%>

<base href="${basePath}">
<%--<%
    System.out.println(basePath);
%>--%>
<%--表达式脚本可以用来引入java代码中的变量--%>
<%--<base href="<%=basePath%>">--%>
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
