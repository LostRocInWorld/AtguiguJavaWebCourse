package com.dustin.servlet;

import com.dustin.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname AjaxServlet
 * @Descrption TODO
 * @Date 2021/7/7下午 10:10
 * @Created By Dustin_Peng
 */
public class AjaxServlet extends BaseServlet{
    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InterruptedException {
        System.out.println("ajax请求成功");
        Person person = new Person(1,"靓仔","男");
        //*********************
        //对于异步请求的验证
        Thread.sleep(3000);
        //*********************
        Gson gson =new Gson();
        //JSON字符串形式
        String personJsonStr = gson.toJson(person);

        resp.getWriter().write(personJsonStr);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InterruptedException {
        System.out.println("jQueryAjax請求成功");

        Person person = new Person(1,"靓仔","男");
        //*********************
        //对于异步请求的验证
        Thread.sleep(3000);
        //*********************
        Gson gson =new Gson();
        //JSON字符串形式
        String personJsonStr = gson.toJson(person);

        resp.getWriter().write(personJsonStr);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InterruptedException {
        System.out.println("jQueryGet請求成功");

        Person person = new Person(1,"靓仔","男");
        //*********************
        //对于异步请求的验证
        Thread.sleep(3000);
        //*********************
        Gson gson =new Gson();
        //JSON字符串形式
        String personJsonStr = gson.toJson(person);

        resp.getWriter().write(personJsonStr);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InterruptedException {
        System.out.println("jQueryPost請求成功");

        Person person = new Person(1,"靓仔","男");
        //*********************
        //对于异步请求的验证
        Thread.sleep(3000);
        //*********************
        Gson gson =new Gson();
        //JSON字符串形式
        String personJsonStr = gson.toJson(person);

        resp.getWriter().write(personJsonStr);
    }

    protected void jQueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InterruptedException {
        System.out.println("jQueryGetJson請求成功");

        Person person = new Person(1,"靓仔","男");
        //*********************
        //对于异步请求的验证
        Thread.sleep(3000);
        //*********************
        Gson gson =new Gson();
        //JSON字符串形式
        String personJsonStr = gson.toJson(person);

        resp.getWriter().write(personJsonStr);
    }
    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InterruptedException {
        System.out.println("jQuerySerialize請求成功");

        Person person = new Person(1,"靓仔","男");

        System.out.println("用户名："+req.getParameter("username"));
        System.out.println("用户名："+req.getParameter("password"));
        //*********************
        //对于异步请求的验证
        Thread.sleep(3000);
        //*********************
        Gson gson =new Gson();
        //JSON字符串形式
        String personJsonStr = gson.toJson(person);

        resp.getWriter().write(personJsonStr);
    }

    }
