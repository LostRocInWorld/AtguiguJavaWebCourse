package com.dustin.dao;

import com.dustin.pojo.Order;

import java.util.List;

/**
 * @Classname OrderDao
 * @Descrption TODO
 * @Date 2021/7/6上午 04:38
 * @Created By Dustin_Peng
 */
public interface OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    int saveOrder(Order order);
    List<Order> queryOrders();
    int changeOrderStatus(String orderId,int status);
    List<Order> queryOrdersByUserId(int userId);

}
