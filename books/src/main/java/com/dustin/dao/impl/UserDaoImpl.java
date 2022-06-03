package com.dustin.dao.impl;

import com.dustin.dao.BaseDao;
import com.dustin.dao.UserDao;
import com.dustin.pojo.User;

/**
 * @Classname UserDaoImpl
 * @Descrption TODO
 * @Date 2021/6/20上午 04:42
 * @Created By Dustin_Peng
 */
public class UserDaoImpl extends BaseDao implements UserDao  {

    @Override
    public User queryUserByUsername(String username) {
        String sql="select `id`,`username`,`password`,`email` from t_user where username=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
        String sql= "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryByUserAndPwd(String username, String pwd) {
        String sql="select `id`,`username`,`password`,`email` from t_user where username=? and password=?";
        return queryForOne(User.class,sql,username,pwd);
    }
}
