package com.xiangcm.spring5.dao;

import com.xiangcm.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

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
        String sql = "insert into t_book values(?,?,?)";
        // 2 调用方法实现
        int result = jdbcTemplate.update(sql,book.getBookId(),book.getBookName(),book.getBookAuthor());
        System.out.println("添加影响的行数：" + result);
    }
    // 修改方法
    @Override
    public void update(Book book) {
        // 1 创建sql语句
        String sql = "update  t_book set bookName = ?,bookAuthor =? where bookId=?";
        // 2 调用方法实现
        Object[] args = {book.getBookName(),book.getBookAuthor(),book.getBookId()};
        int result = jdbcTemplate.update(sql,args);
        System.out.println("修改影响的行数：" + result);
    }
    // 删除方法
    @Override
    public void delete(String bookId) {
        // 1 创建sql语句
        String sql = "delete from  t_book  where bookId=?";
        // 2 调用方法实现
        int result = jdbcTemplate.update(sql,bookId);
        System.out.println("删除影响的行数：" + result);
    }
    // 获取表中的记录数
    @Override
    public int getCount() {
        // 1 创建sql语句
        String sql = "select count(*) from  t_book ";
        // 2 调用方法实现
        int result = jdbcTemplate.queryForObject(sql,Integer.class);
        return result;
    }

    @Override
    public Book getBook(String bookId) {
        // 1 创建sql语句
        String sql = "select * from  t_book where bookId=? ";
        // 2 调用方法实现
        Book result = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),bookId);
        return result;
    }

    @Override
    public List<Book> getAllBook(String bookAuthor) {
        // 1 创建sql语句
        String sql = "select * from  t_book where bookAuthor = ? ";
        // 2 调用方法实现
        List<Book> result = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class),bookAuthor);
        return result;
    }

    @Override
    public int[] batchAdd(List<Object[]> insertValues) {
        String sql = "insert into t_book values(?,?,?)";
        int[] result = jdbcTemplate.batchUpdate(sql, insertValues);
        return result;
    }

    @Override
    public int[] batchUpdate(List<Object[]> insertValues) {
        // 1 创建sql语句
        String sql = "update  t_book set bookName = ?,bookAuthor =? where bookId=?";
        // 2 调用方法实现
        int[] result = jdbcTemplate.batchUpdate(sql,insertValues);
        return result;
    }

    @Override
    public int[] batchDelete(List<Object[]> insertValues) {
        // 1 创建sql语句
        String sql = "delete from  t_book  where bookId=?";
        // 2 调用方法实现
        int[] result = jdbcTemplate.batchUpdate(sql,insertValues);
        return result;
    }
}
