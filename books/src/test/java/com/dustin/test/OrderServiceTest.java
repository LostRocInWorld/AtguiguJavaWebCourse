package com.dustin.test;

import com.dustin.pojo.Cart;
import com.dustin.pojo.CartItem;
import com.dustin.pojo.Order;
import com.dustin.pojo.OrderItem;
import com.dustin.service.OrderService;
import com.dustin.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname OrderServiceTest
 * @Descrption TODO
 * @Date 2021/7/6上午 05:16
 * @Created By Dustin_Peng
 */
public class OrderServiceTest {
    private OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem( new CartItem(1,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem( new CartItem(1,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem( new CartItem(2,"c++",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
        String orderId = orderService.createOrder(cart, 18);
        System.out.println("订单号是："+orderId);
    }

    @Test
    public void showAllOrders() {
        System.out.println(orderService.showAllOrders());
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("162552935327018");
    }

    @Test
    public void showOrderDetails() {
        List<OrderItem> orderItems = orderService.showOrderDetails("162552935327018");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }

    @Test
    public void showMyOrders() {
        for (Order myOrder : orderService.showMyOrders(19)) {
            System.out.println(myOrder);
        }
    }

    @Test
    public void receiveOrder() {
        orderService.receiveOrder("162558007810318");
    }
}