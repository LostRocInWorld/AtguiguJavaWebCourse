package com.dustin.test;

import com.dustin.dao.UserDao;
import com.dustin.dao.impl.UserDaoImpl;
import com.dustin.pojo.User;
import org.junit.Test;

/**
 * @Classname UserDaoTest
 * @Descrption TODO
 * @Date 2021/6/20上午 04:52
 * @Created By Dustin_Peng
 */
public class UserDaoTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if(!(userDao.queryUserByUsername("admin")==null)){
            System.out.println("用户名admin已存在");
        }else {
            System.out.println("用户名admin不存在");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"admin124","123456","12345@qq.com")));

    }

    @Test
    public void queryByUserAndPwd() {
        User user = userDao.queryByUserAndPwd("admin", "admin");
        if(!(user==null)){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}