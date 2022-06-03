package com.dustin.Servlet_06;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname HelloHttpServlet
 * @Descrption TODO
 * @Date 2021/6/18上午 04:43
 * @Created By Dustin_Peng
 */
public class HelloHttpServlet extends HttpServlet {
    //Alt+Insert  -  override Methods 重写doGet和doPost

    /**
     * doGet()  在get请求调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloHttpServlet的doGet方法");

        //也可以使用，获取到ServletConfig
        ServletConfig servletConfig = getServletConfig();//GenericServlet下的getServletConfig()方法

        System.out.println(servletConfig);

//        获取Servlet程序的别名servlet-name的值；
        System.out.println("HelloServlet程序的別名是："+servletConfig.getServletName());
//        获取初始化参数init-param；
        System.out.println("初始化参数username的值是"+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是"+servletConfig.getInitParameter("url"));
//        获取ServletContext对象。
        System.out.println(servletConfig.getServletContext());
    }

    /**
     * doPost()  在post请求调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloHttpServlet的doPost方法");
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //需要调用父类的此方法

        System.out.println("重写了init(ServletConfig config)初始化方法，做了一些工作");
    }
}
