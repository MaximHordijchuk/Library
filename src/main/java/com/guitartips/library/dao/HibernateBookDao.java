package com.guitartips.library.dao;

import com.guitartips.library.domain.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by max on 02.02.15.
 * Have fun!
 */
@Repository
public class HibernateBookDao implements BookDao {

    private static final String GET_USER_BOOKS_QUERY = "SELECT book.book_id, book.title\n" +
            "FROM book\n" +
            "INNER JOIN user_book ON book.book_id = user_book.book_id\n" +
            "WHERE user_id = :user_id";

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateBookDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addBook(Book book) {
        currentSession().save(book);
    }

    @Override
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = (Book) currentSession().get(Book.class, id);
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return book;
    }

    /*@Override
    @SuppressWarnings("unchecked")
    public List<Book> getBooks(int userId) {
        try {
            Session session = currentSession();
            SQLQuery query = session.createSQLQuery(GET_USER_BOOKS_QUERY);
            Query final_query = query.setParameter("user_id", userId);
            return final_query.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return null;
        //return currentSession().createQuery(GET_USER_BOOKS_QUERY).setParameter("user_id", userId).list();
    }*/

    @Override
    public void updateBook(Book book) {
        currentSession().update(book);
    }

    @Override
    public void removeBook(int id) {

    }

}
