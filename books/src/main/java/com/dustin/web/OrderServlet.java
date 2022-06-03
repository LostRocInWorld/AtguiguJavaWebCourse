package com.dustin.web;

import com.dustin.pojo.Cart;
import com.dustin.pojo.Order;
import com.dustin.pojo.OrderItem;
import com.dustin.pojo.User;
import com.dustin.service.OrderService;
import com.dustin.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Classname OrderServlet
 * @Descrption TODO
 * @Date 2021/7/6上午 05:20
 * @Created By Dustin_Peng
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        //获取UserId
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            //未登录跳到登录页面，转发后不执行之后代码，加上return
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
//        System.out.println("OrderServlet程序在线程【"+Thread.currentThread().getName()+"】中");

        Integer id = loginUser.getId();

        //调用OrderService.createOrder(Cart cart, Integer userId)生成订单

        String orderId = null;
        orderId = orderService.createOrder(cart, id);

//        //将订单号放到request域中，重定向无了
//        req.setAttribute("orderId",orderId);
        //将订单号放到Session中
        req.getSession().setAttribute("orderId", orderId);

//        //请求转发，导致重复提交
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);

        //重定向
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询出所有的订单
        List<Order> allOrders = orderService.showAllOrders();
        //保存到Session域中
        if (allOrders != null && allOrders.size() != 0) {
            req.setAttribute("allOrders", allOrders);
        }
        //请求转发到order_manager中
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单号
        String orderId = req.getParameter("orderId");
        if (orderId != null) {
            //发货
            orderService.sendOrder(orderId);
//            req.getRequestDispatcher("/orderServlet?action=showAllOrders").forward(req,resp);
            resp.sendRedirect(req.getContextPath() + "/orderServlet?action=showAllOrders");
        }

    }

    protected void showOrderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前的订单号
        String orderId = req.getParameter("orderId");

        if (orderId != null) {
            //查看订单详情
            List<OrderItem> orderItems = orderService.showOrderDetails(orderId);
            //保存到Request域中
            req.setAttribute("orderItems", orderItems);
            //请求转发
            req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req, resp);

        }
    }

    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前登陆的用户
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            //未登录跳到登录页面，转发后不执行之后代码，加上return
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        List<Order> myOrders = orderService.showMyOrders(loginUser.getId());

        //放到request域中
        req.setAttribute("myOrders", myOrders);
        //请求转发到我的订单页面
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }

    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单号
        String orderId = req.getParameter("orderId");
        if (orderId != null) {
            //签收
            orderService.receiveOrder(orderId);
//            req.getRequestDispatcher("/orderServlet?action=showAllOrders").forward(req,resp);
            resp.sendRedirect(req.getContextPath() + "/orderServlet?action=showMyOrders");
        }
    }
}