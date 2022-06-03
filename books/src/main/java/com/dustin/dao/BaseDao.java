package com.dustin.dao;

import com.dustin.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Classname BaseDao
 * @Descrption TODO
 * @Date 2021/6/20上午 04:15
 * @Created By Dustin_Peng
 */
public abstract class BaseDao {
    //使用DbUtils操作数据
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update方法用来执行update insert delete语句
     *
     * @return
     */
    public int update(String sql, Object... args) {
//        System.out.println("BaseDao程序在线程【"+Thread.currentThread().getName()+"】中");

        Connection conn = JdbcUtils.getConnection();
        try {
            int update = queryRunner.update(conn, sql, args);
            return update;
        }catch (SQLException e){
            e.printStackTrace();
            //当发生异常时，一定要往外抛出，方便JdbcUtils对链接进行事务处理(全部回滚或提交)
            throw new RuntimeException(e);
        }
        //DAO不能关闭连接了，否则每次执行一次都关闭了，引进了事务应该在事务提交或回滚时提交
//        } finally {
//            JdbcUtils.close(conn);
//        }
    }

    /**
     * 查询返回一个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的语句，一般是函数使用
     * @param sql   执行的sql语句
     * @param args  sql对应的参数
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
