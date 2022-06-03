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
import java.util.List;

/**
 * @Classname BookServlet
 * @Descrption TODO
 * @Date 2021/6/29上午 05:50
 * @Created By Dustin_Peng
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int pageNo= WebUtil.parseInt(request.getParameter("pageNo"),0);
        pageNo+=1;
//        1. 获取请求的参数--->封装成为Book对象，注意获取域对象的属性名要与Bean(Book对象)的属性名一致(主要是setXxx方法)
        Book book = WebUtil.copyParamToBean(request.getParameterMap(), new Book());
//        2. 调用BookService.addBook()保存图书
        bookService.addBook(book);
//        3. 跳到图书列表页面
//                /manager/bookServlet?action=list
//        request.getRequestDispatcher("/manager/bookServlet?action=list").forward(request,response);
        //重定向解决表单重复提交的问题
        //pageNo用于添加后定向到末页
        response.sendRedirect(request.getScheme()   //协议
                + "://" + request.getServerName()  //服务器ip
                + ":" + request.getServerPort()    /*//服务器端口*/
                + request.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        1. 获取请求的参数id(图书编号)
        int id = WebUtil.parseInt(request.getParameter("id"), 0);
//        2. 调用BookService.deleteBookById()
        bookService.deleteBookById(id);
//        3. 重定向回图书列表管理页面,/manage/bookServlet?action=list
        response.sendRedirect(request.getScheme()   //协议
                + "://" + request.getServerName()  //服务器ip
                + ":" + request.getServerPort()    //服务器端口
                + request.getContextPath() + "/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取请求参数(封装成Book对象)
        Book book = WebUtil.copyParamToBean(request.getParameterMap(), new Book());
//        2. 调用BookService.updateBook()，修改图书
        bookService.updateBook(book);
//        3. 重定向回图书列表管理页面
        response.sendRedirect(request.getScheme()   //协议
                + "://" + request.getServerName()  //服务器ip
                + ":" + request.getServerPort()    //服务器端口
                + request.getContextPath() + "/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }
    //目前已被page方法代替
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到Request域中
        request.setAttribute("books", books);
        //3.请求转发到/pages/manager/book_manager.jsp
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取图书编号
        int id = WebUtil.parseInt(request.getParameter("id"),0);
//        2. 调用BookService.queryBookById()
        Book book = bookService.queryBookById(id);
//        3. 把图书保存到Request域中
        request.setAttribute("book",book);
//        4. 请求转发到/pages/manager/book_edit.jsp页面，一般debug到最后一行时，点击resume Program(F8)执行完毕，否则会进入源代码中
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取请求的参数:pageNo  pageSize

        int pageNo = WebUtil.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtil.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
//        2. 调用BookService.page(pageNo,pageSize)：Page对象
        Page<Book> page=bookService.page(pageNo,pageSize);
        //設置請求的url地址
        page.setUrl("manager/bookServlet?action=page");
//        3. 保存到Request域中
        request.setAttribute("page",page);
//        4. 请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }


}
