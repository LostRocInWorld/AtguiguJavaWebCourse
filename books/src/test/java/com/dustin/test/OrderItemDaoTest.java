package com.dustin.test;

import com.dustin.dao.OrderItemDao;
import com.dustin.dao.impl.OrderItemDaoImpl;
import com.dustin.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Classname OrderItemDaoTest
 * @Descrption TODO
 * @Date 2021/7/6上午 04:56
 * @Created By Dustin_Peng
 */
public class OrderItemDaoTest {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        //        String sql = "insert into `t_order_item` (`id`,`name`,`price`,`total_money`,`count`,`order_id`) values (?,?,?,?,?,?)";
        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到放弃",2,new BigDecimal(200),new BigDecimal(400),"123456789"));
        orderItemDao.saveOrderItem(new OrderItem(null,"c从入门到放弃",3,new BigDecimal(200),new BigDecimal(600),"123456788"));
        orderItemDao.saveOrderItem(new OrderItem(null,"python从入门到放弃",1,new BigDecimal(200),new BigDecimal(200),"123456787"));
    }

    @Test
    public void queryOrderItemsByOrderId() {
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId("162552935327018");
        orderItems.forEach(System.out::println);

    }
}