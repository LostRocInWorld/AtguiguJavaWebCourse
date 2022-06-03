package com.dustin.web;

import com.dustin.pojo.Book;
import com.dustin.pojo.Cart;
import com.dustin.pojo.CartItem;
import com.dustin.service.BookService;
import com.dustin.service.impl.BookServiceImpl;
import com.dustin.utils.WebUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname CartServlet
 * @Descrption TODO
 * @Date 2021/7/6上午 01:26
 * @Created By Dustin_Peng
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 添加商品項
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车");
//        System.out.println("商品編號為："+req.getParameter("id"));
        //1.获取请求的参数：商品编号
        int id = WebUtil.parseInt(req.getParameter("id"), 0);

        //2.调用bookService.queryBookById(id) 获取商品信息
        Book book = bookService.queryBookById(id);
        //3.把图书信息转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //4.调用Cart.addItem(cartItem)添加商品项
        //从Session中获取cart
        Cart cart = (Cart) req.getSession().getAttribute("cart");
//        Cart cart = new Cart();
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
//        System.out.println(cart);
        //5.重定向回原来商品列表页面
        //获取请求头中发起请求的地址
        String referer = req.getHeader("Referer");
//        System.out.println(referer);

        //将加入购物车的商品名字保存到Session域中，能获取最后添加的商品名
        req.getSession().setAttribute("lastAddName",cartItem.getName());

        resp.sendRedirect(referer);

    }

    /**
     * 刪除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtil.parseInt(req.getParameter("id"), 0);

        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            //删除购物车商品项
            cart.deleteItem(id);
            //重定向回原来购物车展示页面
            String referer = req.getHeader("Referer");
            resp.sendRedirect(referer);
        }

    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clear();
            //重定向回原来购物车展示页面
            String referer = req.getHeader("Referer");
            resp.sendRedirect(referer);
        }
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数：商品编号和商品数量
        int id = WebUtil.parseInt(req.getParameter("id"), 0);
        int count = WebUtil.parseInt(req.getParameter("count"), 0);

        //获取购物车对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null ){
            //修改商品数量
            cart.updateCount(id,count);
            //重定向回原来购物车展示页面
            String referer = req.getHeader("Referer");
            resp.sendRedirect(referer);
        }




    }
    /**
     * 使用AJAX请求添加商品項
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数：商品编号
        int id = WebUtil.parseInt(req.getParameter("id"), 0);

        //2.调用bookService.queryBookById(id) 获取商品信息
        Book book = bookService.queryBookById(id);
        //3.把图书信息book转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //
        //4.从Session中获取cart
        Cart cart = (Cart) req.getSession().getAttribute("cart");
//        Cart cart = new Cart();
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        //5.调用Cart.addItem(cartItem)添加商品项
        cart.addItem(cartItem);
//        System.out.println(cart);
        //6.返回购物车总的商品数量和最后一个添加的商品名称
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());
        resultMap.put("cartNotNull",true);
        Gson gson = new Gson();
        String resultJson = gson.toJson(resultMap);
        resp.getWriter().write(resultJson);
    }

    }
