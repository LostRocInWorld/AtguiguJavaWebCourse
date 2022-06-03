package com.dustin.web;

import com.dustin.pojo.Book;
import com.dustin.pojo.Page;
import com.dustin.service.BookService;
import com.dustin.service.impl.BookServiceImpl;
import com.dustin.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ClientBookServlet
 * @Descrption TODO
 * @Date 2021/7/3上午 02:19
 * @Created By Dustin_Peng
 */
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取请求的参数:pageNo  pageSize
//        System.out.println("經過了前臺的ClientBookServlet程序");
        int pageNo = WebUtil.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtil.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
//        2. 调用BookService.page(pageNo,pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //設置請求的url地址
        page.setUrl("client/bookServlet?action=page");
//        3. 保存到Request域中
        request.setAttribute("page", page);
//        4. 请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取请求的参数:pageNo  pageSize min max
        int pageNo = WebUtil.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtil.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtil.parseInt(request.getParameter("min"),0);
        int max = WebUtil.parseInt(request.getParameter("max"),Integer.MAX_VALUE);//2147483647
//        2. 调用BookService.pageByPrice(pageNo,pageSize,min,max)：Page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(request.getParameter("min")!=null){  //如果有最小价格参数，追加到分页条的地址参数中
            sb.append("&min=").append(request.getParameter("min"));
        }
        if(request.getParameter("max")!=null){  //如果有最大价格参数，追加到分页条的地址参数中
            sb.append("&max=").append(request.getParameter("max"));
        }
        //設置請求的url地址
        page.setUrl(sb.toString());
//        3. 保存到Request域中
        request.setAttribute("page", page);
//        4. 请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
