package com.dustin.test;

import com.dustin.pojo.Cart;
import com.dustin.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Classname CartTest
 * @Descrption TODO
 * @Date 2021/7/5下午 09:30
 * @Created By Dustin_Peng
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem( new CartItem(1,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem( new CartItem(1,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem( new CartItem(2,"c++",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem( new CartItem(1,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem( new CartItem(1,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem( new CartItem(2,"c++",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem( new CartItem(1,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem( new CartItem(1,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem( new CartItem(2,"c++",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem( new CartItem(1,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem( new CartItem(1,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem( new CartItem(2,"c++",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
        cart.updateCount(2,10);
        System.out.println(cart);
    }
}