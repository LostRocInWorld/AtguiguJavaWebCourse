package com.dustin.threadlocal;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname ThreadLocalTest
 * @Descrption TODO
 * @Date 2021/7/7上午 04:52
 * @Created By Dustin_Peng
 */
public class ThreadLocalTest {

    //ConcurrentHashMap,Hashtable线程安全的Map
    public final static Map<String,Object> data = new ConcurrentHashMap<>();
    private static Random random = new Random();

    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static class Task implements Runnable{


        @Override
        public void run() {
            //在run()方法中，随机生成一个变量（线程要关联的变量），然后以当前线程名为key保存到map中
            Integer i = random.nextInt(1000);//0-999随机数
            String threadName = Thread.currentThread().getName();//获取当前线程名
            System.out.println("threadName="+threadName+"生成的隨機數是="+i);

            //存入map中
//            data.put(threadName,i);

            //存入threadLocal中
            threadLocal.set(i);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new OrderService().createOrder();
            new OrderDao().saveOrder();
            //在run()方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
//            Object o = data.get(threadName);
//            System.out.println("綫程["+threadName+"]快結束時取出的關聯數據是="+o);

            //threadLocal取出值
            System.out.println("綫程["+threadName+"]快結束時取出的關聯數據是"+threadLocal.get());
        }
    }

    public static void main(String[] args) {
        for(int i = 0 ;i<3;i++){
            //開啓綫程
            new Thread(new Task()).start();
        }
    }
}
