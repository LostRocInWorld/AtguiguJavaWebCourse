package com.dustin.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Classname AdminFilter
 * @Descrption TODO
 * @Date 2021/7/7上午 02:01
 * @Created By Dustin_Peng
 */
public class AdminFilter implements Filter {

    public AdminFilter(){
        System.out.println("1.Filter构造器方法");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的inint初始化方法");
        //获取Filter的名称filter-name的内容
        System.out.println("filter-init的值是："+filterConfig.getFilterName());
        //获取Filter中配置的init-param初始化参数
        System.out.println("初始化参数username的值是："+filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是："+filterConfig.getInitParameter("url"));
        //获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    /**
     * doFilter 方法，专门用于拦截请求。可以做权限检查
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.Filter的doFilter过滤方法");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = null;
        session=httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        //如果等于null，说明还没有登陆
        if (user == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        }else {
            //让程序继续访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4.Filter的destroy销毁方法");
    }
}
