package com.xiangcm.spring5.dao;

import com.xiangcm.spring5.entity.Book;

import java.util.List;

public interface BookDao {
    public void add(Book book);

    public void update(Book book);

    public void delete(String bookId);

    public int getCount();

    public Book getBook(String bookId);

    public List<Book> getAllBook(String bookAuthor);

    public int[] batchAdd(List<Object[]> insertValues);

    public int[] batchUpdate(List<Object[]> insertValues);

    public int[] batchDelete(List<Object[]> insertValues);
}
