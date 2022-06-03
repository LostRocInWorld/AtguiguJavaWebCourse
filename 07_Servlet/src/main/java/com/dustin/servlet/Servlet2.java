package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/19上午 07:28
 * @Created By Dustin_Peng
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet2程序开始");
        //1.获取请求的参数(办事材料)

        //2.查看Servlet(柜台1)是否有盖章
        Object key = request.getAttribute("key");
        System.out.println("柜台2：柜台1是否有章？"+key);

        //3.处理自己的业务
        System.out.println("柜台2处理自己的流程");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
