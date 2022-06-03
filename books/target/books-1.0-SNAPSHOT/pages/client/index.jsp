<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            //给加入购物车绑定单击事件
            $("button.addToCart").click(function () {
                //在事件响应的function函数中，有一个this对象，这个this对象，是正在相应事件的DOM对象
                //转换成jQuery对象
                var bookId = $(this).attr("bookId");
                <%--location.href = "${basePath}client/cartServlet?action=addItem&id=" + bookId;   /*id=商品编号*/--%>

                // ================================
                // 使用AJAX请求加入购物车
                $.getJSON("${basePath}client/cartServlet", "action=ajaxAddItem&id=" + bookId, function (data) {
                    // console.log(data);
                    if (data.cartNotNull) {
                        $("#cartTotalCount").text("您的购物车中有" + data.totalCount + "件商品");
                        $("#cartLastName").text(data.lastName);
                    }
                });

            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <%--如果用户还没有登录，显示【登录和注册的菜单】--%>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <%--已经登录的情况下，显示登录成功之后的用户信息--%>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
            <a href="orderServlet?action=showMyOrders">我的订单</a>
            <a class="logoutClass" href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
            <script type="text/javascript">
                $(function () {
                    $("a.logoutClass").click(function () {
                        return confirm("你确认要登出吗？");
                    });
                });
            </script>
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <%--定位方法的隐藏域--%>
                <input type="hidden" name="action" value="pageByPrice"/>
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>

        <div style="text-align: center">
            <c:if test="${empty sessionScope.cart.items}">
                <%--购物车为空的输出--%>
                <span id="cartTotalCount"></span>
                <div>
                    <span style="color: red" id="cartLastName">当前购物车为空</span>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <%--购物车非空的输出--%>
                <span id="cartTotalCount">您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>
                <div>
                    您刚刚将<span style="color: red" id="cartLastName">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>
        </div>



        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.img_path}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                            <%--自定义属性bookId--%>
                        <button bookId="${book.id}" class="addToCart">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <%--靜態包含分頁條--%>
    <%@include file="/pages/common/page_nav.jsp" %>

</div>

<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
</body>
</html>