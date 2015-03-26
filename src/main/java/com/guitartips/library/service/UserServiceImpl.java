package com.guitartips.library.service;

import com.guitartips.library.dao.AuthorDao;
import com.guitartips.library.dao.BookDao;
import com.guitartips.library.dao.CommitDao;
import com.guitartips.library.dao.UserDao;
import com.guitartips.library.domain.Book;
import com.guitartips.library.domain.Commit;
import com.guitartips.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
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
    @Autowired
    CommitDao commitDao;

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
    public List<Commit> getUserCommits(String username) {
        return userDao.getUserCommits(username);
    }

    @Override
    @Transactional
    public void commitBook(String username, Book book, Commit commit) {
        int bookId = bookDao.addBook(book);
        commit.setCommitKey(new Commit.CommitKey(username, bookId));
        commit.setDate(Date.valueOf(LocalDate.now()));
        userDao.addBook(commit);
    }
}
