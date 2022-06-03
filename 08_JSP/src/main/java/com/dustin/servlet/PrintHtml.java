package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/23上午 02:19
 * @Created By Dustin_Peng
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintHtml extends HttpServlet {
    org.apache.jasper.runtime.HttpJspBase a;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //通过响应的回传流回传html页面数据
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        writer.write("<!DOCTYPE html>\r\n");
        writer.write("<html lang=\"en\">\r\n");
        writer.write("<head>\r\n");
        writer.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
        writer.write("<title>Title</title>\r\n");
        writer.write("</head>\r\n");
        writer.write("<body>\r\n");
        writer.write("这是html页面的数据\r\n");
        writer.write("</body>\r\n");
        writer.write("</html>\r\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
