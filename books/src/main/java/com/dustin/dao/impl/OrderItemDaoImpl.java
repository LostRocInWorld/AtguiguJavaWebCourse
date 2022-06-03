package com.dustin.dao.impl;

import com.dustin.dao.BaseDao;
import com.dustin.dao.OrderItemDao;
import com.dustin.pojo.OrderItem;

import java.util.List;

/**
 * @Classname OrderItemDaoImpl
 * @Descrption TODO
 * @Date 2021/7/6上午 04:45
 * @Created By Dustin_Peng
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
//        System.out.println("OrderItemDaoImpl程序在线程【"+Thread.currentThread().getName()+"】中");


        String sql = "insert into `t_order_item` (`id`,`name`,`price`,`total_money`,`count`,`order_id`) values (?,?,?,?,?,?)";

        return update(sql,orderItem.getId(),orderItem.getName(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getCount(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String OrderId) {
        String sql = "select `id`,`name`,`price`,`total_money` totalPrice,`count`,`order_id` orderId from t_order_item where order_id= ? ";

        return queryForList(OrderItem.class,sql,OrderId);
    }
}
