<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/23
  Time: 上午 02:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         errorPage="/error500.jsp"
         language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
    这是JSP数据
<div>hello靓仔</div>
    <%!/*声明java代码*/  %>
    <%--  1.声明类属性  --%>
    <%!
        private Integer id;
        private String name;
        private static Map<String,Object> map;
    %>
    <%--  2.声明static静态代码块  --%>
    <%!
        static {
            map = new HashMap<String, Object>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
        }
    %>

    <%--  3.声明类方法  --%>
    <%!
    public int someFun(){
        return 100;
    }
    %>
    <%--  4.声明内部类  --%>
    <%!
        public static class A {
            private Integer id =12;
            private String abc;
        }
    %>

    <%--表达式脚本--%>
    <%--1.输出整型--%>
    <%=12%><br/>
    <%--2.输出浮点型--%>
    <%=12.12%><br/>
    <%--3.输出字符串--%>
    <%="我是字符串"%>
    <%--4.输出对象--%>
    <%=map%><br/>
    <%=request.getParameter("username")%>

    <%--代码脚本--%>
    <%--if语句--%>
    <%
        response.setCharacterEncoding("UTF-8");
        int i =0;
        if(i<0){
            System.out.println("你好靓仔");
        }else {
            System.out.println("吔屎啦你");
        }
    %>
    <%--for循环--%>
    <%
        for(int j=0;j<10;j++){
            System.out.println("*");
        }
    %>
    <br/>
    <%--_翻译后java文件中的_jspService方法内的代码都可以写--%>
    <%
        String username = request.getParameter("username");
        out.print(username);
    %>

    <%--代码脚本还可以由多个代码脚本块组合完成一个完成的java语句。--%>
    <%
        for(int k=0;k<5;k++){
    %>
    <%
            System.out.print(k);
        }
    %>

    <%--代码脚本还可以和表达式脚本组合使用，在jsp页面上输出数据。--%>
    <%
        for(int k=0;k<5;k++){
    %>
    <%=k%><br/>
    <%
        }
    %>

    <%--一个魔幻的例子--%>
    <table border="1" cellspacing="0">
        <%
            for(int j=0;j<10;j++){
        %>
        <tr>
            <td>第<%=j+1%>行</td>
        </tr>
        <%
            }
        %>
    </table>

<%--<%
    int i=12/0;
%>--%>
</body>
</html>
