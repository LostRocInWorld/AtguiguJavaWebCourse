package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/19上午 07:55
 * @Created By Dustin_Peng
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ForwardC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过了forwardC Servlet");
        request.getRequestDispatcher("/a/b/c.html").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
