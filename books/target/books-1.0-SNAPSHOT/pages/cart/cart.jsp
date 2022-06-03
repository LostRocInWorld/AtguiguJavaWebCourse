<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function (){
            //给删除商品项绑定单击事件
            $("a.deleteItemClass").click(function (){
                 return confirm("你确定要移除【"+$(this).parent().parent().find("td:first").text()+"】吗？");
            });
            //给清空购物车绑定单击事件
            $("a.clearClass").click(function (){
                return confirm("你确定要清空购物车吗？");
            });
            //给数量输入框绑定失去焦点事件 ---->  使用onchange事件：内容发生改变事件
            $(":text.updateCount").change(function (){
                //获取商品名称
                var name = $(this).parent().parent().find("td:first").text();
                var count = $(this).val();
               if( confirm("你确定要将【"+name+"】商品修改数量：【"+count+"】吗？")){
                  var id = $(this).attr("bookId");
                    //发起请求给服务器保存修改
                   location.href = "${basePath}client/cartServlet?action=updateCount&count="
                       +count+"&id="+id;
               }else {
                   //修改为原来的数量,defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值
                   this.value = this.defaultValue;
               }
            });
        });
    </script>
</head>
<body>
<%--	<%=session.getAttribute("cart")%>--%>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%--静态包含登陆成功之后的菜单--%>
    <%@ include file="/pages/common/loginSuccessMenu.jsp" %>
</div>

<div id="main">
    <%--购物车是空的情况--%>
    <c:if test="${empty sessionScope.cart.items}">
        <table>
            <tr>
                <td>商品名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>金额</td>
                <td>操作</td>
            </tr>
            <tr>
                <td colspan="5"><a href="index.jsp">当前购物车为空，返回首頁添加商品...</a></td>
            </tr>
        </table>
    </c:if>

    <%--购物车非空的情况--%>
    <c:if test="${not empty sessionScope.cart.items}">
        <table>
            <tr>
                <td>商品名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>金额</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input bookId="${entry.value.id}" class="updateCount" style="width: 80px;" type="text" name="book_count" value="${entry.value.count}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItemClass" href="client/cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a class="clearClass" href="client/cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder&">去结账</a></span>
        </div>
    </c:if>

</div>

<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>