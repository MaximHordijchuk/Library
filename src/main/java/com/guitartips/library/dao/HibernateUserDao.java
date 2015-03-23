package com.guitartips.library.dao;

import com.guitartips.library.domain.Book;
import com.guitartips.library.domain.Commit;
import com.guitartips.library.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by max on 16.02.15.
 * Have fun!
 */
@Repository
public class HibernateUserDao implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(String username) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getUserBooks(String username) {
        try {
            User user = entityManager.find(User.class, username);
            return user.getBooks();
        } catch (PersistenceException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    @Override
    public void addBook(String username, int bookId) {
        try {
            Commit commit = new Commit(username, bookId, Date.valueOf(LocalDate.now()), "Nice book!");
            entityManager.persist(commit);
        } catch (PersistenceException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
