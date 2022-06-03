package com.dustin.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Classname MySevletContextListenerImpl
 * @Descrption TODO
 * @Date 2021/6/24上午 04:21
 * @Created By Dustin_Peng
 */
public class MySevletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext被销毁了");
    }
}
