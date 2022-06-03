package com.dustin.service;

import com.dustin.pojo.Cart;
import com.dustin.pojo.Order;
import com.dustin.pojo.OrderItem;

import java.util.List;

/**
 * @Classname OrderService
 * @Descrption TODO
 * @Date 2021/7/6上午 05:06
 * @Created By Dustin_Peng
 */
public interface OrderService {
    /**
     * 生成订单号
     * @param cart
     * @param userId
     * @return
     */
    String createOrder(Cart cart,Integer userId);
    List<Order> showAllOrders();
    int sendOrder(String orderId);
    List<OrderItem> showOrderDetails(String orderId);
    List<Order> showMyOrders(int userId);
    int receiveOrder(String orderId);

}
