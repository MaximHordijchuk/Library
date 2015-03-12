package com.guitartips.library.service;

import com.guitartips.library.dao.BookDao;
import com.guitartips.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by max on 04.02.15.
 */
@Service
public class BookServiceImpl implements BookService {

    BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    @Transactional
    public Book getBookById(int bookId) {
        return bookDao.getBookById(bookId);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int bookId) {
        bookDao.removeBook(bookId);
    }
}
