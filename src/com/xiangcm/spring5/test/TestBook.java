package com.xiangcm.spring5.test;

import com.xiangcm.spring5.entity.Book;
import com.xiangcm.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: TestBook
 * @Description: 测试类
 * @Author: DELL
 * @Date: 2021/1/18 21:45
 **/
public class TestBook {
    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setBookId("001");
        book.setBookName("疯狂Java");
        book.setBookAuthor("李刚");
        bookService.addBook(book);
    }
}
