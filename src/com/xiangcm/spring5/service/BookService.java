package com.xiangcm.spring5.service;

import com.xiangcm.spring5.dao.BookDao;
import com.xiangcm.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void addBook(Book book){
        bookDao.add(book);
    }
}
