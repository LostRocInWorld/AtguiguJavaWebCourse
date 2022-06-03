package com.dustin.service;

import com.dustin.pojo.Book;
import com.dustin.pojo.Page;

import java.util.List;

/**
 * @Classname BookService
 * @Descrption TODO
 * @Date 2021/6/29上午 05:17
 * @Created By Dustin_Peng
 */
public interface BookService {
    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
