package com.dustin.filter;

import com.dustin.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Classname ManagerFilter
 * @Descrption TODO
 * @Date 2021/7/7上午 04:33
 * @Created By Dustin_Peng
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");
        if(user== null){
            //未登陆进入登陆页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        }else if("admin".equals(user.getUsername())){
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //没权限进首页
            request.getRequestDispatcher("/index.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
