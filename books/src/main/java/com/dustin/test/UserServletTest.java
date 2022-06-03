package com.dustin.test;

import java.lang.reflect.Method;

/**
 * @Classname UserServletTest
 * @Descrption TODO
 * @Date 2021/6/27上午 02:17
 * @Created By Dustin_Peng
 */
public class UserServletTest {
    public void login(){
        System.out.println("login()方法被调用了");
    }

    public void regist(){
        System.out.println("regist()方法被调用了");
    }
    public void updateUser(){
        System.out.println("updateUser()方法被调用了");

    }

    public void updatePassword(){
        System.out.println("updatePassword()方法被调用了");
    }

    public static void main(String[] args) {
        String action="regist";
//        String action="login";

        try {
            //通过action字符串获取相应的业务方法  反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
//            System.out.println(method);
            //调用目标业务方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
