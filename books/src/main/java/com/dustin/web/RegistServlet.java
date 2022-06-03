package com.dustin.web; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/22下午 08:42
 * @Created By Dustin_Peng
 */

import com.dustin.pojo.User;
import com.dustin.service.UserService;
import com.dustin.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用了RegistServlet的doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(request,response);
        request.setCharacterEncoding("UTF-8");

//        1. 获取请求参数；
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        int sum = Integer.sum(100, 200);


//        2. 检查 验证码是否正确  暂时写死要求验证码为:abcde
        if ("abcde".equalsIgnoreCase(code)) {
//              正确
//                   3.检查用户名是否可用
            if (userService.existUsername(username)) {
//      	            不可用,跳回注册页面
//                System.out.println("用户名已存在：" + username);
                //把回显信息保存到request域中
                request.setAttribute("msg","用户名已存在!");
                request.setAttribute("username",username);
                request.setAttribute("email",email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
//                      可用
//   		    调用Service保存到数据库，跳到注册成功页面regist_success.html
                userService.registerUser(new User(null,username,password,email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
//            System.out.println("---验证码错误:" + code);
            //把回显信息保存到request域中
            request.setAttribute("msg","验证码错误!");
            request.setAttribute("username",username);
            request.setAttribute("email",email);

            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
}
