package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/19下午 09:35
 * @Created By Dustin_Peng
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Response2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("定向到了RESPONSE2");
        response.getWriter().write("RESPONSE2 RESULT!!!");

        //不共享Request域中的数据
        request.getAttribute("username");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
