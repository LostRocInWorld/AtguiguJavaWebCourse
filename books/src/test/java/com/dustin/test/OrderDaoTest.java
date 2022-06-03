package com.dustin.test;

import com.dustin.dao.OrderDao;
import com.dustin.dao.impl.OrderDaoImpl;
import com.dustin.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Classname OrderDaoTest
 * @Descrption TODO
 * @Date 2021/7/6上午 04:49
 * @Created By Dustin_Peng
 */
public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderDao.saveOrder(new Order("123456789", sdf.format(new Date()), new BigDecimal(400), 0, 18));
        orderDao.saveOrder(new Order("123456788", sdf.format(new Date()), new BigDecimal(600), 0, 18));
        orderDao.saveOrder(new Order("123456787", sdf.format(new Date()), new BigDecimal(200), 0, 18));
    }

    @Test
    public void queryOrders() {
        System.out.println(orderDao.queryOrders());
    }

    @Test
    public void changeOrderStatus() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderDao.changeOrderStatus("162558007810318",1);
        //162552935327018
    }

    @Test
    public void queryOrdersByUserId() {
        List<Order> orders = orderDao.queryOrdersByUserId(19);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}