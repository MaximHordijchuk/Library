package com.guitartips.library.service;

import com.guitartips.library.domain.Book;
import com.guitartips.library.domain.Commit;
import com.guitartips.library.domain.User;

import java.util.List;

/**
 * Created by max on 16.02.15.
 * Have fun!
 */
public interface UserService {

    public void addUser(User user);

    public User getUserByUsername(String username);

    public void updateUser(User user);

    public void removeUser(String username);

    public void commitBook(String username, Book book, Commit commit);

    public List<Commit> getUserCommits(String username);

}
