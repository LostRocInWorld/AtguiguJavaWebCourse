package com.dustin.Servlet_06; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/18下午 08:56
 * @Created By Dustin_Peng
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取web.xml配置的上下文参数context-param
        ServletContext servletContext = this.getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        System.out.println("context-param参数username的值是："+username);
        System.out.println("context-param参数password的值是："+password);

//        2. 获取当前的工程路径，格式：/工程名
        System.out.println("當前工程路徑"+servletContext.getContextPath());

/*
*          3. 获取工程部署后在服务器磁盘上的绝对路径
            *  "/" 被服务器解析地址为:http://ip:port/工程名 映射到IDEA代码的webapp目录
            */
        System.out.println("工程部署的路徑"+servletContext.getRealPath("/"));
        //D:\IdeaJavaProject\JavaWebs\06_Servlet\target\Servlet_06-1.0-SNAPSHOT\
        System.out.println("工程下css目錄的絕對路徑是  "+servletContext.getRealPath("/css"));
        System.out.println("工程下imgs/1.jpg目錄的絕對路徑是"+servletContext.getRealPath("/imgs/1.jpg"));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
