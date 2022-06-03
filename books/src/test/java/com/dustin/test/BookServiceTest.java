package com.dustin.test;

import com.dustin.pojo.Book;
import com.dustin.service.BookService;
import com.dustin.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Classname BookServiceTest
 * @Descrption TODO
 * @Date 2021/6/29上午 05:41
 * @Created By Dustin_Peng
 */
public class BookServiceTest {
    private BookService bookService=new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "软饭硬吃的机种方法", "某成", new BigDecimal(998), 2, 15, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(24, "如何吃软饭", "1111", new BigDecimal(998), 45441, 105545, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(24));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        };
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1,4));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1,4,10,50));
    }
}