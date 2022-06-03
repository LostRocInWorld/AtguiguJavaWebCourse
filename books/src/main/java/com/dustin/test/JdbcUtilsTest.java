package com.dustin.test;

import com.dustin.utils.JdbcUtils;
import org.junit.Test;

/**
 * @Classname JdbcUtilsTest
 * @Descrption TODO
 * @Date 2021/6/20上午 04:11
 * @Created By Dustin_Peng
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        System.out.println(JdbcUtils.getConnection());
    }
}
