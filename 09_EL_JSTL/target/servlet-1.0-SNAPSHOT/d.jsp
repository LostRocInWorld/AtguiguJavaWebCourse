<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/24
  Time: 下午 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>关系运算</h1><br/>
"12==12"${12 == 12}或${12 eq 12}<br/>
"12!=12"${12 != 12}或${12 ne 12}<br/>
"12<12"${12 < 12}或${12 lt 12}<br/>
"12>12"${12 > 12}或${12 gt 12}<br/>
"12<=12"${12 <= 12}或${12 le 12}<br/>
"12>=12"${12 >= 12}或${12 ge 12}<br/>
<h1>逻辑运算</h1>
"12==12&&12>11"${12==12&&12>11}或${12==12 and 12>11}<br/>
"12==12||12>11"${12==12 || 12>11}或${12==12 or 12>11}<br/>
"! 12==12"${! (12==12)}或${not (12==12)}<br/>
<br/>
<h1>算术运算</h1>
"12+12"${12+12}<br/>
"12-12"${12-12}<br/>
"12*12"${12*12}<br/>
"12/12"${12/12}或${12 div 12}<br/>
"13%12"${13%12}或${13 mod 12}<br/>

<%
//    1. 值为null值的时候，为空；
    request.setAttribute("emptyNull",null);
//    2. 值为空串的时候，为空；
    request.setAttribute("emptyString","");
//    3. 值是Object类型数组，长度为0的时候；
    request.setAttribute("emptyArr",new Object[]{});
//    4. list集合，元素个数为0；
    List<String> list=new ArrayList<>();
//    list.add("value1");   //有元素时，返回false
    request.setAttribute("emptyList",list);
//    5. map集合，元素个数为0.
    Map<String,Object> map=new HashMap<>();
//    map.put("key1","value1"); //有元素时，返回false
    request.setAttribute("emptyMap",map);
%>
<h1>empty运算</h1>
emptyNull:${empty emptyNull}<br/>
emptyString:${empty emptyString}<br/>
emptyArr:${empty emptyArr}<br/>
emptyList:${empty emptyList}<br/>
emptyMap:${empty emptyMap}<br/>
<hr/>
<h1>三元运算符</h1>
${12 == 12 ? "你好靓仔" : "靓仔去世"}
</body>
</html>
