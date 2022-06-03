<%--
  Created by IntelliJ IDEA.
  User: Dustin_Peng
  Date: 2021/6/25
  Time: 上午 02:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${ param }<br/>
输入请求参数user的值${ param.user}<br/>
<hr/>
${ paramValues }<br/>
输入请求参数hobby的第二个值${paramValues.hobby[1]}<br/>

<hr/>
${header}<br/>
输出请求头参数【Usr-Agent】的值${header["User-Agent"]}<br/>

<hr/>
输出请求头参数【Usr-Agent】的值${headerValues["User-Agent"][0]}

<hr/>
输出cookie的名称${cookie.JSESSIONID.name}<br/>
输出cookie的值${cookie.JSESSIONID.value}<br/>

<hr/>
输出initParam${initParam}
输出&lt;Context-param&gt;中username的值${initParam.username}<br/>

</body>
</html>
