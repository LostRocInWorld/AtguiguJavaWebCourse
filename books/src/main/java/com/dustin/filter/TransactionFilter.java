package com.dustin.filter;

import com.dustin.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Classname TransactionFilter
 * @Descrption TODO
 * @Date 2021/7/7上午 07:43
 * @Created By Dustin_Peng
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);  //把异常抛给Tomcat服务器管理展示
        }
    }

    @Override
    public void destroy() {

    }
}
