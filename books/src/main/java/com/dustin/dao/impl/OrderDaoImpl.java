package com.dustin.dao.impl;

import com.dustin.dao.BaseDao;
import com.dustin.dao.OrderDao;
import com.dustin.pojo.Order;

import java.util.List;

/**
 * @Classname OrderDaoImpl
 * @Descrption TODO
 * @Date 2021/7/6上午 04:40
 * @Created By Dustin_Peng
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
//        System.out.println("OrderDaoImpl程序在线程【"+Thread.currentThread().getName()+"】中");

        String sql = "insert into `t_order` (`order_id`,`create_time`,`total_money`,`status`,`user_id`) values (?,?,?,?,?)";
        return  update(sql,order.getOrderId(),order.getCreateTime(),order.getTotalPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select `order_id` orderId,`create_time` createTime,`total_money` totalPrice,`status` status,`user_id` userId from t_order";//
        List<Order> orders = queryForList(Order.class, sql);
        return orders;
    }

    @Override
    public int changeOrderStatus(String orderId,int status) {
        String sql = "update `t_order` set status = ? where order_id=?";
        return update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(int userId) {
        String sql = "select `order_id` orderId,`create_time` createTime,`total_money` totalPrice,`status` status,`user_id` userId from t_order " +
                "where user_id = ?";
        return queryForList(Order.class,sql,userId);
    }


}
