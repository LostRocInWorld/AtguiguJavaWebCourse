package com.dustin.dao.impl;

import com.dustin.dao.BaseDao;
import com.dustin.dao.BookDao;
import com.dustin.pojo.Book;

import java.util.List;

/**
 * @Classname BookDaoImpl
 * @Descrption TODO
 * @Date 2021/6/28下午 09:44
 * @Created By Dustin_Peng
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    /**
     * 添加圖書
     * @param book
     * @return
     */
    @Override
    public int addBook(Book book) {
        String sql="insert into t_book( `name` , `author` , `price` , `sales` , `stock` , `img_path`)\n" +
                "values( ? , ? , ? , ? , ? , ? );";

        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());
    }

    /**
     * 通過id刪除圖書
     * @param id
     * @return
     */
    @Override
    public int deleteBookById(Integer id) {
        String sql="delete from t_book where id = ?";
        return update(sql,id);
    }

    /**
     * 更新圖書信息
     * @param book
     * @return
     */
    @Override
    public int updateBook(Book book) {
//        System.out.println("BookDaoImpl程序updateBook在线程【"+Thread.currentThread().getName()+"】中");
        String sql="update t_book set `name` =?, `author` =?, `price` =?, `sales` =?, `stock` =?, `img_path`=? " +
                "where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    /**
     * 通過id查詢圖書
     * @param id
     * @return
     */
    @Override
    public Book queryBookById(Integer id) {

//        System.out.println("BookDaoImpl程序在queryBookById线程【"+Thread.currentThread().getName()+"】中");
        String sql="select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    /**
     * 查詢所有的圖書
     * @return
     */
    @Override
    public List<Book> queryBooks() {
        String sql="select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book ";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql="select count(*) from t_book";
        Number number = (Number) queryForSingleValue(sql);//此处不能从Long转为Integer，先转换为Number，再调用intValue方法
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql="select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql="select count(*) from t_book where price between ? and ?";
        Number number = (Number) queryForSingleValue(sql,min,max);//此处不能从Long转为Integer，先转换为Number，再调用intValue方法
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql="select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` " +
                "from t_book " +
                "where price between ? and ? order by price " +
                "limit ?,?";
        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }
}
