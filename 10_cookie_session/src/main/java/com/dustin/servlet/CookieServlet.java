package com.dustin.servlet;

import com.dustin.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname CookieServlet
 * @Descrption TODO
 * @Date 2021/7/3上午 05:30
 * @Created By Dustin_Peng
 */
public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象，可创建多个Cookie对象
        Cookie cookie = new Cookie("key1", "value1");

        //2.通知客户端保存Cookie(服务器通知客户端都是通过响应response)
        resp.addCookie(cookie);
        //1.创建Cookie对象，可创建多个Cookie对象
        Cookie cookie2 = new Cookie("key2", "value2");

        //2.通知客户端保存Cookie(服务器通知客户端都是通过响应response)
        resp.addCookie(cookie2);

        resp.getWriter().write("Cookie創建成功了");

    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //Cookie.getName()方法返回Cookie的key名）
            //Cookie.getName()方法返回Cookie的value（值）
            resp.getWriter().write("Cookies[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
        }

        //获取指定的Cookie
        Cookie iWantCookie = CookieUtils.findCookie("key2", cookies);
        resp.getWriter().write("找到了需要的Cookie="+iWantCookie.getValue());

    }


    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*//        **方案一**
//        1. 先创建一个要修改的同名的Cookie对象。
//        2. 在构造器，同时赋予新的Cookie值。
        Cookie cookie = new Cookie("key2","newValue2");
//        3. 调用response.addCookie(cookie).
        resp.addCookie(cookie);

        resp.getWriter().write("key2的Cookie已經修改好");*/


//        1. 先查找到需要修改的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1",req.getCookies());
//        2. 调用setValue方法赋予新的Cookie值
        if (cookie != null) {
            cookie.setValue("newValue1");
        }
//        3. response.addCookie(cookie) 通知客户端保存Cookie
        resp.addCookie(cookie);

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);   //设置存活时间
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.找到你需要删除的Cookie对象
        Cookie cookie =CookieUtils.findCookie("key1",req.getCookies());
        //2.调用setMaxAge(0)
        if(cookie!=null){
            cookie.setMaxAge(0);    //表示马上删除，不需要等待浏览器关闭
        }
        //3.通知客户端
        resp.addCookie(cookie);
        resp.getWriter().write("key1的cookie已经被删除");
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.找到你需要删除的Cookie对象
        Cookie cookie =new Cookie("life3600","life3600");
        //2.调用setMaxAge(3600)
        cookie.setMaxAge(3600); //设置Cookie再3600s后被删除，无效？
        //3.通知客户端
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的cookie");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1","path1");
        //req.getContextPath()---工程路径
        cookie.setPath(req.getContextPath()+"/abc");    //        /工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建一个带有path路径的Cookie");
    }


    }
