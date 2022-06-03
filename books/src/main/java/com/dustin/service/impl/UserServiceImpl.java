package com.dustin.service.impl;

import com.dustin.dao.UserDao;
import com.dustin.dao.impl.UserDaoImpl;
import com.dustin.pojo.User;
import com.dustin.service.UserService;

/**
 * @Classname UserServiceImpl
 * @Descrption TODO
 * @Date 2021/6/20上午 05:21
 * @Created By Dustin_Peng
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryByUserAndPwd(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
