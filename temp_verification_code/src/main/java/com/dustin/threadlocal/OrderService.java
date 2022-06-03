package com.dustin.threadlocal;

/**
 * @Classname OrderSevice
 * @Descrption TODO
 * @Date 2021/7/7上午 05:05
 * @Created By Dustin_Peng
 */
public class OrderService {
    public void createOrder(){
        //取綫程關聯數據
        String name = Thread.currentThread().getName();
//        //通過存入Hashtable中取出
//        System.out.println("OrderService 當前綫程["+name+"]保存的數據是"+ThreadLocalTest.data.get(name));

        //通過threadLocal取出
        System.out.println("OrderService 當前綫程["+name+"]保存的數據是"+ThreadLocalTest.threadLocal.get());

    }
}
