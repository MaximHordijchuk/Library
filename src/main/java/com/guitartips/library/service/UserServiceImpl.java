package com.guitartips.library.service;

import com.guitartips.library.dao.AuthorDao;
import com.guitartips.library.dao.UserDao;
import com.guitartips.library.domain.Author;
import com.guitartips.library.domain.Book;
import com.guitartips.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by max on 16.02.15.
 * Have fun!
 */
@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;
    AuthorDao authorDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, AuthorDao authorDao) {
        this.userDao = userDao;
        this.authorDao = authorDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {

    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    @Transactional
    public void updateUser(User user) {

    }

    @Override
    @Transactional
    public void removeUser(String username) {

    }

    @Override
    @Transactional
    public List<Book> getUserBooks(String username) {
        List<Book> books = userDao.getUserBooks(username);
        for (Book book : books) {
            List<Author> authors = authorDao.getBookAuthors(book.getId());
            book.setAuthors(authors);
        }
        return books;
    }

    @Override
    @Transactional
    public void addBook(String username, int bookId) {
        userDao.addBook(username, bookId);
    }
}
