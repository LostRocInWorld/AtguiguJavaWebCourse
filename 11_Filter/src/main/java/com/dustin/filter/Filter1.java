package com.dustin.filter; /**
 *  @Classname ${NAME}
 *  @Descrption TODO
 *  @Date 2021/7/7上午 03:50
 *  @Created By Dustin_Peng
 */
import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter1前置代碼");
        System.out.println("Filter1的线程"+Thread.currentThread().getName());
        System.out.println("Filter1的request域中username参数："+request.getParameter("username"));
        request.setAttribute("user","admin123");
        chain.doFilter(request,response);
        System.out.println("Filter1后置代碼");
    }
}
