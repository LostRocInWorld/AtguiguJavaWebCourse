package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/19下午 08:50
 * @Created By Dustin_Peng
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIO extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取响应的默认字符集：ISO-8859-1
        System.out.println(response.getCharacterEncoding());
//        //设置服务器响应的字符集为UTF-8
//        response.setCharacterEncoding("UTF-8");
//        //通过响应头，设置浏览器也使用UTF-8字符集
//        response.setHeader("Content-Type","text/html; charset=UTF-8");

        //setContentType()它会同时设置服务器和客户端浏览器都是用UTF-8字符集，还设置了响应头
        //此方法一定要在获取流对象之前使用才有效
        response.setContentType("text/html;charset=UTF-8");

        //获取setContentType()设置之后的服务器字符集
        System.out.println(response.getCharacterEncoding());

        //往客户端回传字符串 数据
        PrintWriter writer = response.getWriter();
//        writer.write("response's content!!");
        writer.write("靓仔你好！");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
