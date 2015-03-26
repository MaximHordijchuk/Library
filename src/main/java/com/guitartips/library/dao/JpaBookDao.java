package com.guitartips.library.dao;

import com.guitartips.library.domain.Book;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by max on 02.02.15.
 * Have fun!
 */
@Repository
public class JpaBookDao implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int addBook(Book book) {
        entityManager.persist(book);
        return book.getId();
    }

    @Override
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = entityManager.find(Book.class, id);
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return book;
    }

    @Override
    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void removeBook(int id) {

    }

}
