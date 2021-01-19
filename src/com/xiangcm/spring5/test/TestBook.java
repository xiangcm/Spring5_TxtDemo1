package com.xiangcm.spring5.test;

import com.xiangcm.spring5.entity.Book;
import com.xiangcm.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setBookId("001");
        book.setBookName("Mysql");
        book.setBookAuthor("大山");
        bookService.updateBook(book);
    }
    @Test
    public void testDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.deleteBook("001");
    }

    @Test
    public void testGetCount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.getCount();
    }

    @Test
    public void testGetBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = bookService.getBook("1");
        System.out.println(book);
    }

    @Test
    public void testGetAllBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> books = bookService.getAllBook("李刚");
        System.out.println(books);
    }

    @Test
    public void testBatchAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> insertValues = new ArrayList<>();
        Object[] val1 = {"001","spring","小A"};
        Object[] val2 = {"002","spring4","小B"};
        Object[] val3 = {"003","spring5","小C"};
        insertValues.add(val1);
        insertValues.add(val2);
        insertValues.add(val3);
        int[] result  = bookService.batchAdd(insertValues);
        System.out.println("批量插入的结果为："+ Arrays.toString(result));
    }

    @Test
    public void testBatchUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> insertValues = new ArrayList<>();
        Object[] val1 = {"myBatis","小小A","001"};
        Object[] val2 = {"myBatis2","小小B","002"};
        Object[] val3 = {"myBatis3","小小C","003"};
        insertValues.add(val1);
        insertValues.add(val2);
        insertValues.add(val3);
        int[] result  = bookService.batchUpdate(insertValues);
        System.out.println("批量修改的结果为："+ Arrays.toString(result));
    }

    @Test
    public void testBatchDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> insertValues = new ArrayList<>();
        Object[] val1 = {"001"};
        Object[] val2 = {"002"};
        Object[] val3 = {"003"};
        insertValues.add(val1);
        insertValues.add(val2);
        insertValues.add(val3);
        int[] result  = bookService.batchDelete(insertValues);
        System.out.println("批量删除的结果为："+ Arrays.toString(result));
    }
}
