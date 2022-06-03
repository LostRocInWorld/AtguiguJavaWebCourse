package com.dustin.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Classname JdbcUtils
 * @Descrption TODO
 * @Date 2021/6/20上午 03:21
 * @Created By Dustin_Peng
 */
public class JdbcUtils {
    /**
     * 获取数据库连接池中的连接
     *
     * @return 如果返回null，说明获取连接失败，有值就是获取连接成功
     */
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> threadConns = new ThreadLocal<>();

    static {

        try {
            Properties properties = new Properties();
            //读取jdbc.properties文件,2021版IDEA将jdbc放入\src\main\resources中
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //创建了数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从数据库连接池中获取连接，并保存到ThreadLocal中
     * @return  返回null，获取失败
     */

    public static Connection getConnection() {
        Connection conn = threadConns.get();
//        try {
//            conn = dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                //保存到ThreadLocal中，供后面的JDBC操作使用
                threadConns.set(conn);

                //关闭自动提交
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection conn = threadConns.get();
        if(conn != null){
            //说明之前使用来操作过数据库
            try {
                conn.commit();  //提交事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    conn.close();   //关闭连接
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        threadConns.remove();   //移除线程中保存的Connection，因为Tomcat服务器底层使用了线程池技术
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection conn = threadConns.get();
        if(conn != null){
            //说明之前使用来操作过数据库
            try {
                conn.rollback();  //回滚事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    conn.close();   //关闭连接
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        threadConns.remove();   //移除线程中保存的Connection，因为Tomcat服务器底层使用了线程池技术
    }
//    /**
//     * @param connection
//     */
//    public static void close(Connection connection) {
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public static void main(String[] args) {
//        URL resource = JdbcUtils.class.getClassLoader().getResource("");
//        System.out.println(resource);
//    }
}
