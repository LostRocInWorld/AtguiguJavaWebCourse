package com.dustin.util;

import javax.servlet.http.Cookie;

/**
 * @Classname CookieUtils
 * @Descrption TODO
 * @Date 2021/7/3上午 06:20
 * @Created By Dustin_Peng
 */
public class CookieUtils {
    /**
     * 查找指定名称的Cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if (name == null ||cookies==null||cookies.length==0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
