package com.dustin.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Classname WebUtil
 * @Descrption 把map中的值注入到对应的JavaBean中
 * @Date 2021/6/27上午 03:31
 * @Created By Dustin_Peng
 */
public class WebUtil {
    public static <T> T copyParamToBean(Map value, T bean) {
        //        1. 获取请求参数，使用BeanUtils优化
//        System.out.println("注入之前" + bean);
        //使用BeanUtils进行注入
        try {
            BeanUtils.populate(bean, value);
//            System.out.println("注入之后" + bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换为字符串类型
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            System.out.println("当前值可能为null或其他错误，返回默认值defaultValue");
//            e.printStackTrace();
        }
        return defaultValue;
    }
}

