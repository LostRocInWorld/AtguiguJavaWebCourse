package com.dustin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Classname BaseServlet
 * @Descrption TODO
 * @Date 2021/6/27上午 02:46
 * @Created By Dustin_Peng
 */

public abstract class BaseServlet extends HttpServlet {
    protected void servletInvMethod(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //解决post请求中文乱码问题
        request.setCharacterEncoding("UTF-8");
        //解决响应中文乱码问题
        response.setContentType("text/html;charset=UTF-8"); //設置響應亂碼的問題
        //目的是为了代码复用，是用abstract修饰
        String action = request.getParameter("action");
        //反射优化else if
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        servletInvMethod( request,  response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletInvMethod( req,  resp);
    }
}
