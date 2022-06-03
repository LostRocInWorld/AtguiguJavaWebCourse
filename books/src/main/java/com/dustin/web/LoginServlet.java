package com.dustin.web; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/23上午 01:37
 * @Created By Dustin_Peng
 */

import com.dustin.pojo.User;
import com.dustin.service.UserService;
import com.dustin.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取请求的参数；
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        2. 调用XxxService.xxx()处理业务；
        User loginUser = userService.login(new User(null, username, password, null));
//        3. 根据login()方法返回结果判断登录
        if(loginUser==null){
//          3.2 失败  跳回登录页面
            //把错误信息和回显的表单项信息，保存到request域中(请求转发request仍是同一个且有效)
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",username);
//            System.out.println("用戶名或密碼錯誤");

            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else {
//          3.1 成功  跳到登录成功页面
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }
}
