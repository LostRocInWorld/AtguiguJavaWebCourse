package com.dustin.dao;

import com.dustin.pojo.Book;

import java.util.List;

/**
 * @Classname BookDao
 * @Descrption TODO
 * @Date 2021/6/28下午 09:42
 * @Created By Dustin_Peng
 */
public interface BookDao {
    public int addBook(Book book);
    public int deleteBookById(Integer id);
    public int updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    public List<Book> queryForPageItems(int begin,int pagesize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize,int min,int max);
}
