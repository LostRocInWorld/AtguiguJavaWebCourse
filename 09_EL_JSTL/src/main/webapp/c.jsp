<%@ page import="com.dustin.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/24
  Time: 下午 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person=new Person();
    person.setName("靓仔你好");
    person.setPhones(new String[]{"18821760379","18688886666","17209701245"});

    List<String> cities= new ArrayList<>();
    cities.add("上海");
    cities.add("北京");
    cities.add("苏州");
    person.setCities(cities);

    Map<String,Object> map=new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);

    pageContext.setAttribute("person",person);
%>
<h1>输出person</h1>
${person}<br/>
<h2>输出person的name属性</h2>
${person.name}<br/>
<h2>输出person的phones数组属性值</h2>
${person.phones[0]}<br/>
<h2>输出person的cities List属性值</h2>
${person.cities}<br/>
<h2>输出person的cities List个别属性值</h2>
${person.cities.get(1)}<br/>
或者<br/>
${person.cities[2]}<br/>
<br/>
<h2>输出person的map集合</h2>
${person.map}<br/>
<h2>输出person的map集合中某个key的值</h2>
${person.map.key1}<br/>

<h2>输出person的age属性</h2>
${person.age}<br/>
</body>
</html>
