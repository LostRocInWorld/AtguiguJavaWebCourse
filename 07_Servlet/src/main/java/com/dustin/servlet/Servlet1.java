package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/19上午 07:28
 * @Created By Dustin_Peng
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet1程序开始");
        //1.获取请求参数(办证材料)
        String username = request.getParameter("username");
        System.out.println("在Servlet1(柜台1)查看参数(材料)："+username);

        //2.给材料盖一个章并传递到Servlet2查看
        request.setAttribute("key","柜台1的章");

        //3.问路:Servlet2(柜台2)怎么走.
        /*
        * 请求转发必须要要以 / 开头，斜杠表示地址到:http://ip:port/工程名，映射到IDEA下webapp目录
        *
        * */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/form1.html");

        //4.走向柜台2
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
