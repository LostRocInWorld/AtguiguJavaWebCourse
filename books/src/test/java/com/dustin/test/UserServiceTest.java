package com.dustin.test;

import com.dustin.pojo.User;
import com.dustin.service.UserService;
import com.dustin.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @Classname UserServiceTest
 * @Descrption TODO
 * @Date 2021/6/20上午 05:24
 * @Created By Dustin_Peng
 */
public class UserServiceTest {
    UserService userService =new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"bbj168","123556","bbj168@qq.com"));
        userService.registerUser(new User(null,"abc168","123556","abc168@qq.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"abc168","123556","abc168@qq.com")));
    }

    @Test
    public void existUsername() {
        if(userService.existUsername("admin")){
            System.out.println("用户名存在");
        }else{
            System.out.println("用户名不存在");
        }

    }
}