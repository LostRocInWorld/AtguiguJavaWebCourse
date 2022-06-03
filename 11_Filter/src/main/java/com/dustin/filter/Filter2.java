package com.dustin.filter; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/7/7上午 03:53
 * @Created By Dustin_Peng
 */

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter2前置代碼");
        System.out.println("Filter2的线程"+Thread.currentThread().getName());
        System.out.println("Filter2的request域中username参数："+request.getParameter("username"));
        System.out.println("Filter2的取Filter1保存的参数user："+request.getAttribute("user"));

        //如果注释Filter2如下代码，不会继续执行
        chain.doFilter(request,response);
        System.out.println("Filter2后置代碼");
    }
}
