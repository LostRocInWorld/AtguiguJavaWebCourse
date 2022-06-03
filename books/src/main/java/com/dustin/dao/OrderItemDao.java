package com.dustin.dao;

import com.dustin.pojo.OrderItem;

import java.util.List;

/**
 * @Classname OrderItemDao
 * @Descrption TODO
 * @Date 2021/7/6上午 04:39
 * @Created By Dustin_Peng
 */
public interface OrderItemDao {
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    int saveOrderItem(OrderItem orderItem);
    List<OrderItem> queryOrderItemsByOrderId(String OrderId);
}
