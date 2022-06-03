package com.dustin.service.impl;

import com.dustin.dao.BookDao;
import com.dustin.dao.impl.BookDaoImpl;
import com.dustin.pojo.Book;
import com.dustin.pojo.Page;
import com.dustin.service.BookService;

import java.util.List;

/**
 * @Classname BookServiceImpl
 * @Descrption TODO
 * @Date 2021/6/29上午 05:39
 * @Created By Dustin_Peng
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        //设置当前页码
        //设置每页显示数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页数
        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;  //求当前页数据的开始索引
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        //设置当前页码
        //设置每页显示数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页数
        page.setPageNo(pageNo);

        //查询当前页数据
        int begin = (page.getPageNo() - 1) * pageSize;  //求当前页数据的开始索引
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize,min,max);
        //设置当前页数据
        page.setItems(items);
        return page;
    }
}
