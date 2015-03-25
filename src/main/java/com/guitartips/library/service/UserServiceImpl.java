package com.guitartips.library.service;

import com.guitartips.library.dao.AuthorDao;
import com.guitartips.library.dao.BookDao;
import com.guitartips.library.dao.UserDao;
import com.guitartips.library.domain.Book;
import com.guitartips.library.domain.Commit;
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

    @Autowired
    UserDao userDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;

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
        return userDao.getUserBooks(username);
    }

    @Override
    @Transactional
    public List<Commit> getUserCommits(String username) {
        return userDao.getUserCommits(username);
    }

    @Override
    @Transactional
    public void addNewBook(String username, Book book) {
        int bookId = bookDao.addBook(book);
        userDao.addBook(username, bookId);
    }
}
