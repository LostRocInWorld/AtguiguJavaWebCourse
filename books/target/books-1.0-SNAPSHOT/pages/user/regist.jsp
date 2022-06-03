<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
<%--    静态包含base标签，css样式，jquery文件--%>
    <%@ include file="/pages/common/head.jsp"%>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
    <script>
        //页面加载完成后
        $(function () {
            //给【用户名】绑定内容改变事件
            $("#username").change(function (){
                //1.获取用户名
                var username =this.value;
                //2.发起ajax请求
                $.getJSON("${basePath}userServlet","action=ajaxExistsUsername&username="+username,function (data){
                    // console.log(data);
                    if(data.existsUsername){
                        $("span.errorMsg").text("用户名已存在");
                    }else {
                        $("span.errorMsg").text("用户名可用");
                    }
                });
            });

            //给【注册】绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5-12位
                //1.获取用户名输入框内容
				var username = $("#username").val();
                //2.创建正则表达式对象
				var usernamePatt = /^\w{5,12}$/;
                //3.使用test方法验证
				if(!(usernamePatt.test(username))){
					//4.提示用户结果
					$("span.errorMsg").text("用户不合法");
					return false;	//阻止提交
				}



                // 验证密码：必须由字母，数字下划线组成，并且长度位5-12位
				//1.获取密码输入框内容
				var password = $("#password").val();
				//2.创建正则表达式对象
				var passwordPatt = /^\w{5,12}$/;
				//3.使用test方法验证
				if(!(passwordPatt.test(password))){
					//4.提示用户结果
					$("span.errorMsg").text("密码不合法");
					return false;	//阻止提交
				}


                // 验证确认密码：和密码相同
				//1.获取确认密码内容
				var repwdText = $("#repwd").val();

				//2.与密码相比较
				if(!(repwdText==password)){
					//3.提示用户结果
					$("span.errorMsg").text("两次密码不一致");
					return false;
				}


                // 邮箱验证：xxxxx@xxx.com
				//1.获取邮箱输入框内容
				var email = $("#email").val();
				//2.创建正则表达式对象
				var emailPatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				//3.使用test方法验证
				if(!(emailPatt.test(email))){
					//4.提示用户结果
					$("span.errorMsg").text("邮箱格式不合法");
					return false;	//阻止提交
				}

                // 验证码：现在只需验证用户已输入。还未学习到服务器，验证码生成。
				//1.获取验证码输入框内容
				var codeText = $("#code").val();
				//2.去掉验证码的前后空格
                // alert("去空格前："+codeText);
                codeText = $.trim(codeText);
                // alert("去空格后："+codeText);
                //3.验证验证码是否输入
				if(codeText== null ||codeText==""){
					//4.提示用户结果
					$("span.errorMsg").text("验证码为空");
					return false;	//阻止提交
				}

				//验证ok后，之前的提示信息取消
				$("span.errorMsg").text("");
            });

            //给验证码图片绑定单击事件
            $("#codeimg").click(function (){
                // alert("点击了验证码的图片");
                //在事件响应的function函数有一个this对象。这个this对象是当前正在响应事件的dom对象
                //src属性表示img标签的图片路径。它可读可写。
                // alert(this.src);
                this.src="${basePath}kaptcha.jpg?date="+new Date(); //设置验证码图片dom对象的src属性为这个servlet
                //赋值后重新发起请求，加上一个参数date为时间戳，保证跳过缓存获取新的验证码
                // alert(this.src);
            });
        });
    </script>


</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
<!--					错误提示信息-->
                    <span class="errorMsg">
                        <%--<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
<!--                    <form action="regist_success.jsp">-->
					<form action="userServlet" METHOD="post">	<!--http://localhost:8080/books/registServlet-->
                        <input type="hidden" name="action" value="regist"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username"
                        <%--value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
                                value="${requestScope.username}"
                        />
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1" name="email" id="email"
                               <%--value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"--%>
                                value="${requestScope.email}"
                        />
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 80px;" id="code"/>
                        <img alt="" id="codeimg" src="kaptcha.jpg" style="float: right; margin-right: 40px;width: 110px;height: 30px;">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="/pages/common/foot.jsp"%>
</body>
</html>