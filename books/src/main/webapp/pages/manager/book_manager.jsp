<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@ include file="/pages/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%--		静态包含manager管理模块的菜单--%>
    <%@ include file="/pages/common/manage_menu.jsp" %>
    <script type="text/javascript">
        $(function () {
            //给删除的a标签绑定单击事件
            $("a.deleteClass").click(function () {
                //this对象表示正在相应的dom对象
                /**
                 * confirm是确认提示框函数
                 * 参数是它的提示内容
                 * 两个按钮确认和取消，分别返回true和false
                 */
                var book_name = $(this).parent().parent().find("td:first").text();
                return confirm("你确认要删除[" + book_name + "]?");
                //return false阻止元素的默认行为
            })
        });
    </script>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                    <%--
                                    <td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update">修改</a></td>
                    --%>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
            <%--
                        <td><a href="pages/manager/book_edit.jsp?method=add">添加图书</a></td>
            --%>
        </tr>
    </table>
<%--    分頁條的開始
    <div id="page_nav">
        大于首页，才显示
        <c:if test="${requestScope.page.pageNo > 1}">
            <a href="${requestScope.page.url}&pageNo=1">首页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        </c:if>

            页码输出的开始

            <c:choose>
                情况1，当总页码小于5，页码的范围是1-总页码；
                <c:when test="${requestScope.page.pageTotal <=5}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>

                    <c:forEach begin="1"  end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                情况2，当总页码大于5，例如总页码为10
                <c:when test="${requestScope.page.pageTotal >5}">
                    <c:choose>
                        且当前页码处于1-3时，页码范围是1-5；
                        <c:when test="${requestScope.page.pageNo <= 3}">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="5"/>
                            <c:forEach begin="1"  end="5" var="i">
                                <c:if test="${i == requestScope.page.pageNo}">
                                    【${i}】
                                </c:if>
                                <c:if test="${i != requestScope.page.pageNo}">
                                    <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        当前页码处于最后三个,页码范围是总页码-4至总页码
                        <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
                            <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                            <c:set var="end" value="${requestScope.page.pageTotal}"/>
                            <c:forEach begin="${requestScope.page.pageTotal-4}"  end="${requestScope.page.pageTotal}" var="i">
                                <c:if test="${i == requestScope.page.pageNo}">
                                    【${i}】
                                </c:if>
                                <c:if test="${i != requestScope.page.pageNo}">
                                    <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        当前页码是4-7时，页码范围为当前页码-2至当前页码+2
                        <c:otherwise>
                            <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                            <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                            <c:forEach begin="${requestScope.page.pageNo-2}"  end="${requestScope.page.pageNo+2}" var="i">
                                <c:if test="${i == requestScope.page.pageNo}">
                                    【${i}】
                                </c:if>
                                <c:if test="${i != requestScope.page.pageNo}">
                                    <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </c:when>
            </c:choose>
            获取上述判断的begin和end来输出页码
            <c:forEach begin="${begin}" end="${end}" var="i">
                <c:if test="${i == requestScope.page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i != requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
            页码输出的结束
            如果已经时最后一页，就不显示下一页
        <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
        </c:if>
        共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
        到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
        <input id="searchPageBtn" type="button" value="确定">
        <script type="text/javascript">
            $(function (){
                //跳到指定的页码
                $("#searchPageBtn").click(function (){
                   var pageNo= $("#pn_input").val();
                   // console.log(pageNo);
                   var pageTotal =${requestScope.page.pageTotal};
                   //javaScript中提供了location地址栏对象
                    // 属性href，可以获取浏览器地址栏中的地址，可读可写
                    // alert(location.href);
                    // location.href="http://localhost:8080/books/manager/bookServlet?action=page&pageNo="+pageNo;
                    location.href="${pageScope.basePath}${requestScope.page.url}&pageNo="+pageNo;
                });
            });
        </script>
    </div>
    分頁條的結束--%>
    <%--靜態包含分頁條--%>
    <%@include file="/pages/common/page_nav.jsp"%>
</div>

<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>