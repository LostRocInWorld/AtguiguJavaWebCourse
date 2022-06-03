package com.dustin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Classname SessionServlet
 * @Descrption TODO
 * @Date 2021/7/3下午 09:19
 * @Created By Dustin_Peng
 */
public class SessionServlet extends BaseServlet{
    protected void createGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session会话对象
        HttpSession session= req.getSession();
        //判断当前Session会话是否是新创建的
        boolean isNew = session.isNew();

        //获取Session会话的唯一标识 id
        String id  = session.getId();

        resp.getWriter().write("得到的Session，它的id是："+id+"<br/>");
        resp.getWriter().write("得到的Session是否是新创建的："+isNew+"<br/>");
    }

    /**
     * 往Session中保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("往Session中保存了key1的数据");
    }

    /**
     * 获取Session域中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中获取key1的数据是："+attribute);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int defaultLife = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认超时时间为："+defaultLife+"秒");
    }

    protected void life30(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session对象
        HttpSession session = req.getSession();
        //设置当前Session在30s后超时
        session.setMaxInactiveInterval(30);

        resp.getWriter().write("当前Session已经设置为30s后超时");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session对象
        HttpSession session = req.getSession();
        //设置当前Session在马上超时
        session.invalidate();

        resp.getWriter().write("当前Session已经立即销毁");
    }


    }
