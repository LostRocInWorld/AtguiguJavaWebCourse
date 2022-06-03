package com.dustin.threadlocal;

/**
 * @Classname OrderDao
 * @Descrption TODO
 * @Date 2021/7/7上午 05:10
 * @Created By Dustin_Peng
 */
public class OrderDao {

    public void saveOrder(){
        //取綫程關聯數據
        String name = Thread.currentThread().getName();
//        //通過存入Hashtable中取出
//        System.out.println("OrderDao 當前綫程["+name+"]保存的數據是"+ThreadLocalTest.data.get(name));

        //通過threadLocal取出
        System.out.println("OrderDao 當前綫程["+name+"]保存的數據是"+ThreadLocalTest.threadLocal.get());

    }
}
