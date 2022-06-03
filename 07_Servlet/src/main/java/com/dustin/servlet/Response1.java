package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/19下午 09:35
 * @Created By Dustin_Peng
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过RESPONSE1");

        //方案一：
        //1.设置响应状态码,表示重定向
        response.setStatus(302);
        //2.设置响应头，说明新的地址Location
        response.setHeader("Location","http://localhost:8080/07_Servlet/response2");

        //不共享Request域中的数据
        request.setAttribute("username","root");
        //不能访问WEB-INF目录下的资源
//        response.setHeader("location","http://localhost:8080/07_Servlet/WEB-INF/form1.html");
        //可以访问工程以外的资源
//        response.setHeader("location","http://www.baidu.com");

        //方案二：
        response.sendRedirect("http://localhost:8080/07_Servlet/response2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
