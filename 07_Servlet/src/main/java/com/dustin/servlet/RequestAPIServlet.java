package com.dustin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname RequestAPIServlet
 * @Descrption TODO
 * @Date 2021/6/19上午 06:31
 * @Created By Dustin_Peng
 */
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. getRequestURI()	获取请求的URI(资源)地址
        System.out.println("URI==>"+req.getRequestURI());   //  /07_Servlet/request
//        2. getRequestURL()    获取请求的统一资源定位符(绝对路径)
        System.out.println("URL==>"+req.getRequestURL());   // http://localhost:8080/07_Servlet/request
//        3. getRemoteHost()    获取客户端的ip地址
        System.out.println("客户端ip地址==>"+req.getRemoteHost());
        /*在IDEA中使用localhost或者127.0.0.1访问时，得到客户端ip地址是：127.0.0.1
        * 在IDEA中使用真实ip访问时，得到客户端地址是真实的ip地址
        * */
//        4. getHeader()    获取请求头
        System.out.println("请求头User-Agent==>"+req.getHeader("User-Agent"));

//        5. getParameter()    获取请求的参数

//        7. getMethod()    获取请求的方式(GET或POST)
        System.out.println("请求的方式==>"+req.getMethod());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
