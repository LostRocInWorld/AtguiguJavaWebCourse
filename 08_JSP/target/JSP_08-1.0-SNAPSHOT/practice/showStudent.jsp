<%@ page import="com.dustin.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/24
  Time: 上午 02:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 600px;
            border: 1px #ff3d33 solid;
            text-align: center;
            border-collapse: collapse;  /*合并边框*/
        }
        td,th{
            border: 1px #ff3d33 solid;
        }
    </style>
</head>
<body>
<h1>学生信息</h1>
<%
    //通过request对象获取查询的学生信息
    List<Student> studentList = (List<Student>) request.getAttribute("studentList");
%>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>PHONE</th>
        <th>操作</th>
    </tr>
    <%
        for (Student student : studentList) {
    %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getPhone()%></td>
        <td><a href="">删除</a>&nbsp;&nbsp;<a href="">修改</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
