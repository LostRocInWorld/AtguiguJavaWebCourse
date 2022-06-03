package com.dustin.test;

import com.dustin.utils.JdbcUtils;
import org.junit.Test;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for(int i = 0;i<=100;i++){
            //已經設置了最大的鏈接數，所以在不釋放時只能獲取最大連接數的Connection
            System.out.println(JdbcUtils.getConnection());
            //需要及時釋放
            JdbcUtils.commitAndClose();
        }
    }
}
