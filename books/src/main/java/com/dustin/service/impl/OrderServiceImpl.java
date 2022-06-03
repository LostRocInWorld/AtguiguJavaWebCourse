package com.dustin.service.impl;

import com.dustin.dao.BookDao;
import com.dustin.dao.OrderDao;
import com.dustin.dao.OrderItemDao;
import com.dustin.pojo.Order;
import com.dustin.dao.impl.BookDaoImpl;
import com.dustin.dao.impl.OrderDaoImpl;
import com.dustin.dao.impl.OrderItemDaoImpl;
import com.dustin.pojo.*;
import com.dustin.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Classname OrderServiceImpl
 * @Descrption TODO
 * @Date 2021/7/6上午 05:06
 * @Created By Dustin_Peng
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
//        System.out.println("OrderServiceImpl程序在线程【"+Thread.currentThread().getName()+"】中");

        //保存订单
        String orderId=System.currentTimeMillis()+""+userId;  //订单号+用户id唯一
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Order order = new Order(orderId,sdf.format(new Date()),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);

        //模拟出现错误是，阻塞了后面操作的进行
//        int i = 12/0;


        //遍历购物车中的商品转换成订单项，保存到数据库
        for(Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            //获取每一个购物车商品项
            CartItem cartItem = entry.getValue();
            //转换成订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            //更新销量和库存
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()- cartItem.getCount());
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        List<Order> allOrders = orderDao.queryOrders();
        return allOrders;
    }

    @Override
    public int sendOrder(String orderId) {
        return orderDao.changeOrderStatus(orderId,1);
    }

    @Override
    public List<OrderItem> showOrderDetails(String orderId) {
        return orderItemDao.queryOrderItemsByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(int userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public int receiveOrder(String orderId) {
        return orderDao.changeOrderStatus(orderId,2);
    }
}
