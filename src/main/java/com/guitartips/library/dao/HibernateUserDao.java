package com.guitartips.library.dao;

import com.guitartips.library.domain.Book;
import com.guitartips.library.domain.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by max on 16.02.15.
 * Have fun!
 */
@Repository
public class HibernateUserDao implements UserDao {
    private static final String GET_USER_BOOKS_QUERY =
            "SELECT BOOK.*\n" +
            "FROM BOOK INNER JOIN USER_BOOK ON BOOK.id = USER_BOOK.book_id\n" +
            "WHERE username = :username";

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateUserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(int userId) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getUserBooks(String username) {
        try {
            /*Session session = currentSession();
            SQLQuery query = session.createSQLQuery(GET_USER_BOOKS_QUERY).addEntity(Book.class);
            Query final_query = query.setParameter("username", username);
            return final_query.list();*/
            return currentSession().createSQLQuery(GET_USER_BOOKS_QUERY).addEntity(Book.class)
                    .setParameter("username", username).list();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    @Override
    public void addBook(int userId, int bookId) {

    }
}
