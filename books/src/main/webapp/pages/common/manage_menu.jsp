<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/26
  Time: 下午 09:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <%--action表示需要调用bookServlet中的哪个方法--%>
    <a href="manager/bookServlet?action=page">图书管理</a>

    <a href="manager/manageOrderServlet?action=showAllOrders">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>
