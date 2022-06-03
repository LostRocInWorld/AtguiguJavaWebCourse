<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dustin.pojo.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/25
  Time: 上午 04:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table {
            border: 1px solid red;
            border-collapse: collapse;
        }
        th,td{
            border: 1px solid red;
        }
    </style>

</head>
<body>
<hr/>
<h1>&lt;c:foreach/&gt;标签</h1>
<h2>遍历1到10，输出</h2>
<c:forEach begin="1" end="10" var="i">
    <h3>${i}<br/></h3>
</c:forEach>

<table>
    <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${i}行</td>
        </tr>
    </c:forEach>
</table>
<hr/>
<h2>遍历Object數組</h2>
<%
    request.setAttribute("arr",new String[]{"123","456","789"});
%>
<c:forEach items="${requestScope.arr}" var="item">
    ${item}<br/>
</c:forEach>

<hr/>
<h2>遍歷Map</h2>
<%
    Map<String ,Object> map=new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    for(Map.Entry<String,Object> entry: map.entrySet()){
        System.out.println(entry);
    }
    request.setAttribute("map",map);
%>
<c:forEach items="${requestScope.map}" var="mapItem">
    ${mapItem}<br/>
    ${mapItem.key}和
    ${mapItem.value}<br/>
</c:forEach>
<hr/>
<h2>遍歷List集合</h2>
<%
    List<Student> studentList = new ArrayList<>();
    for(int i=1;i<11;i++){
        studentList.add(new Student(i,"username"+i,"pass"+i,i+19,"phone"+i));
    }
    request.setAttribute("stus",studentList);
%>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>电话</th>
        <th>操作</th>
    </tr>
<c:forEach items="${requestScope.stus}" begin="2" end="7" step="2" var="student" varStatus="status">
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.password}</td>
        <td>${student.age}</td>
        <td>${student.phone}</td>
        <td>删除丶修改</td>
        <td>${status.first}</td><%--自动调用的是读方法，对于boolean类型的数据，其读方法是isFirst()--%>
        <td>${status.current}</td><%--EL表达式${variable}输出的应该先搜索是当前JSTL标签作用域中的变量--%>
    </tr>
</c:forEach>
</table>

</body>
</html>
