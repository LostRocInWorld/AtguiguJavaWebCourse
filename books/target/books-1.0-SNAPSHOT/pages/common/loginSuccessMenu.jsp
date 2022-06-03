<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/26
  Time: 下午 08:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="orderServlet?action=showMyOrders">我的订单</a>
    <a class="logoutClass" href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <script type="text/javascript">
        $(function (){
            $("a.logoutClass").click(function (){
                return confirm("你确认要登出吗？");
            });
        });
    </script>
    <a href="index.jsp">返回主页</a>
</div>
