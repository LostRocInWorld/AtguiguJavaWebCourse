<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <base href="http://localhost:8080/temp_verification_code/"/>
</head>
<body>
    <form action="registerServlet" method="post">
        用户名:<input type="text" name="username" /><br/>
        <%--密码:<input type="password" name="password" ><br/>--%>
        验证码:<input type="text" style="width: 80px;" name="code" />
        <img src="kaptcha.jpg" style="width: 100px;height: 28px;" alt=""/><br/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>