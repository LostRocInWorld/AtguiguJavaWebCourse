<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
	<script type="text/javascript">
		$(function (){
			$("a.receiveClass").click(function (){
				return confirm("你确认要签收吗？");
			});
		});

	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<%@ include file="/pages/common/loginSuccessMenu.jsp"%>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
				<td>动作</td>
			</tr>
			<c:forEach items="${requestScope.myOrders}" var="order">
			<tr>
				<td>${order.createTime}</td>
				<td>${order.totalPrice}</td>

				<c:choose>
					<c:when test="${order.status == 0}">
						<td>未发货</td>
						<td><a href="orderServlet?action=showOrderDetails&orderId=${order.orderId}">查看详情</a></td>
						<td></td>
					</c:when>
					<c:when test="${order.status == 1}">
						<td>发货中</td>
						<td><a href="orderServlet?action=showOrderDetails&orderId=${order.orderId}">查看详情</a></td>
						<td><a class="receiveClass" href="orderServlet?action=receiveOrder&orderId=${order.orderId}">确认签收</a></td>
					</c:when>
					<c:otherwise>
						<td>已签收</td>
						<td><a href="orderServlet?action=showOrderDetails&orderId=${order.orderId}">查看详情</a></td>
						<td></td>
					</c:otherwise>
				</c:choose>

			</tr>
			</c:forEach>
			</tr>
		</table>
		
	
	</div>
	
	<%@ include file="/pages/common/foot.jsp"%>
</body>
</html>