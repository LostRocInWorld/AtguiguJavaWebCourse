package com.dustin.Servlet_06; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/18下午 09:37
 * @Created By Dustin_Peng
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println("保存之前：ContextServlet2中获取域数据key1的值是："+context.getAttribute("key1"));
        System.out.println("context2中的ServletContext對象:"+context);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
