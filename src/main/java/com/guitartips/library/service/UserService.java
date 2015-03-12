package com.guitartips.library.service;

import com.guitartips.library.domain.Book;
import com.guitartips.library.domain.User;

import java.util.List;

/**
 * Created by max on 16.02.15.
 * Have fun!
 */
public interface UserService {

    public void addUser(User user);

    public User getUserById(int userId);

    public void updateUser(User user);

    public void removeUser(int userId);

    public List<Book> getUserBooks(String username);

    public void addBook(int userId, int bookId);

}
