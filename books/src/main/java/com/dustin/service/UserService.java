package com.dustin.service;

import com.dustin.pojo.User;

/**
 * @Classname UserService
 * @Descrption TODO
 * @Date 2021/6/20上午 05:18
 * @Created By Dustin_Peng
 */
public interface UserService {
    /**
     * 注册用户
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user
     * @return  如果返回null，说明登录失败，返回有值，登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return  返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existUsername(String username);
}
