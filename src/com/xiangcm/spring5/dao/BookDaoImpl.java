package com.xiangcm.spring5.dao;

import com.xiangcm.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: BookDaoImpl
 * @Description: BookDao实现类
 * @Author: DELL
 * @Date: 2021/1/18 21:13
 **/
@Repository
public class BookDaoImpl implements BookDao{
    // 注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // 添加方法
    @Override
    public void add(Book book) {
        // 1 创建sql语句
        String addSql = "insert into t_book values(?,?,?)";
        // 2 调用方法实现
        int result = jdbcTemplate.update(addSql,book.getBookId(),book.getBookName(),book.getBookAuthor());
        System.out.println("添加的条数：" + result);
    }
}
