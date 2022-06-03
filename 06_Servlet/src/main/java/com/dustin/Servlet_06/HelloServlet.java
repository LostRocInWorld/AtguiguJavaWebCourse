package com.dustin.Servlet_06;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    //Alt+Insert快捷键添加implements methods


    public HelloServlet() {
        System.out.println("1. 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2. init初始化");

//        1. 可以获取Servlet程序的别名servlet-name的值；
        System.out.println("HelloServlet程序的別名是："+servletConfig.getServletName());
//        2. 获取初始化参数init-param；
        System.out.println("初始化參數username的值是"+servletConfig.getInitParameter("username"));
        System.out.println("初始化參數url的值是"+servletConfig.getInitParameter("url"));
//        3. 获取ServletContext对象。
        System.out.println(servletConfig.getServletContext());//org.apache.catalina.core.ApplicationContextFacade@33e850fa
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 Hello Servlet 被訪問了");
        //类型转换(HttpServletRequest有getMethod()方法)
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求方式
        String method = httpServletRequest.getMethod();
//        System.out.println(method); //get请求对应GET post请求对应POST
        if("GET".equals(method)){
//            System.out.println("get请求");
            doGet();
        }else if("POST".equals(method)){
//            System.out.println("post请求");
            doPost();
        }
    }

    public void doGet(){
        System.out.println("get請求");
        System.out.println("get請求");
    }

    public void doPost(){
        System.out.println("post請求");
        System.out.println("post請求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy方法");
    }
}