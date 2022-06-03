package com.dustin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname LoginServlet
 * @Descrption TODO
 * @Date 2021/7/3下午 08:57
 * @Created By Dustin_Peng
 */
public class LoginServlet extends BaseServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "admin123".equals(password)) {
            //登陆成功
            Cookie cookie = new Cookie("username",username);
            cookie.setMaxAge(3600); //当前Cookie一小时有效
            resp.addCookie(cookie);
            System.out.println("登陆成功");
        }else {
            //登陆失败
            System.out.println("登陆失败");
        }
    }
}
