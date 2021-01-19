package com.xiangcm.spring5.service;

import com.xiangcm.spring5.dao.BookDao;
import com.xiangcm.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: BookService
 * @Description: BookService类
 * @Author: DELL
 * @Date: 2021/1/18 21:12
 **/
@Service
public class BookService {
    @Autowired // 注入aao
    private BookDao bookDao;
    //添加
    public void addBook(Book book){
        bookDao.add(book);
    }

    //修改
    public void updateBook(Book book){
        bookDao.update(book);
    }

    //删除
    public void deleteBook(String bookId){
        bookDao.delete(bookId);
    }

    //查询记录
    public void getCount() {
       int result = bookDao.getCount();
        System.out.println("book表中的记录数：" + result);
    }

    //查询对象
    public Book getBook(String bookId) {
        Book book = bookDao.getBook(bookId);
        return book;
    }

    //查询对象集合
    public List<Book> getAllBook(String bookAuthor) {
        List<Book>  books = bookDao.getAllBook(bookAuthor);
        return books;
    }

    // 批量添加操作
    public int[] batchAdd(List<Object []> insertValues){
        int[] result = bookDao.batchAdd(insertValues);
        return result;
    }

    // 批量修改操作
    public int[] batchUpdate(List<Object []> insertValues){
        int[] result = bookDao.batchUpdate(insertValues);
        return result;
    }

    // 批量删除操作
    public int[] batchDelete(List<Object []> insertValues){
        int[] result = bookDao.batchDelete(insertValues);
        return result;
    }
}
