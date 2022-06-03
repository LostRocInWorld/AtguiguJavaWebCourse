package com.dustin.threadlocal;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;


public class ThreadTestBefore {


        //ConcurrentHashMap,Hashtable线程安全的Map
        public final static Map<String,Object> data = new ConcurrentHashMap<>();
        private static Random random = new Random();


        public static class Task implements Runnable{


            @Override
            public void run() {
                //在run()方法中，随机生成一个变量（线程要关联的变量），然后以当前线程名为key保存到map中
                Integer i = random.nextInt(1000);//0-999随机数
                String threadName = Thread.currentThread().getName();//获取当前线程名
                System.out.println("threadName="+threadName+"生成的隨機數是="+i);

                //存入map中
            data.put(threadName,i);


                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //在run()方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
            Object o = data.get(threadName);
            System.out.println("綫程["+threadName+"]快結束時取出的關聯數據是="+o);

            }
        }

        public static void main(String[] args) {
            for(int i = 0 ;i<3;i++){
                //開啓綫程
                new Thread(new Task()).start();
            }
        }
    }

