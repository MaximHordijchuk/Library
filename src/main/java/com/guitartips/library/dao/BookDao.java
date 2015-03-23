package com.guitartips.library.dao;


import com.guitartips.library.domain.Book;

/**
 * Created by max on 02.02.15.
 * Have fun!
 */
public interface BookDao {

    public int addBook(Book book);

    public Book getBookById(int bookId);

    public void updateBook(Book book);

    public void removeBook(int bookId);

}
