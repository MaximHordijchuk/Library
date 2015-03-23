package com.guitartips.library.service;


import com.guitartips.library.domain.Book;

/**
 * Created by max on 04.02.15.
 * Have fun!
 */
public interface BookService {

    public int addBook(Book book);

    public Book getBookById(int bookId);

    public void updateBook(Book book);

    public void removeBook(int bookId);

}
