package com.dustin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname LoginServlet
 * @Descrption TODO
 * @Date 2021/7/7上午 02:23
 * @Created By Dustin_Peng
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决响应乱码
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("admin".equals(username)&&"123456".equals(password)){
            //登陆成功
            req.getSession().setAttribute("user",username);
            resp.getWriter().write("<br/>登陆成功!!!<br/>");
        }else {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
