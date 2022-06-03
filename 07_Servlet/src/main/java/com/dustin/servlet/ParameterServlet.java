package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/19上午 06:45
 * @Created By Dustin_Peng
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        System.out.println("------GET------");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("兴趣："+ Arrays.asList(hobbies));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        System.out.println("------------POST--------------");
        //String password = request.getParameter("password");
        //setCharacterEncoding()设置请求体的字符集为UTF-8，解决post请求中文乱码的问题
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("兴趣："+ Arrays.asList(hobbies));
    }
}
