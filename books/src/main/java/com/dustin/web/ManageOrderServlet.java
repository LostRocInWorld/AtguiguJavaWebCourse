package com.dustin.web;

import com.dustin.pojo.Order;
import com.dustin.service.OrderService;
import com.dustin.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Classname ManageOrderServlet
 * @Descrption TODO
 * @Date 2021/7/9上午 03:21
 * @Created By Dustin_Peng
 */
public class ManageOrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

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
}
