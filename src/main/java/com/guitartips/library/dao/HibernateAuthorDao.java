package com.guitartips.library.dao;

import com.guitartips.library.domain.Author;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by max on 01.03.15.
 * Have fun!
 */
@Repository
public class HibernateAuthorDao implements AuthorDao {

    private static final String GET_BOOK_AUTHORS_QUERY =
            "SELECT AUTHOR.*\n" +
                    "FROM AUTHOR INNER JOIN AUTHOR_BOOK ON AUTHOR.id = AUTHOR_BOOK.author_id\n" +
                    "WHERE book_id = :bookId";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addAuthor(Author author) {

    }

    @Override
    public Author getAuthorById(int authorId) {
        return null;
    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void removeAuthor(int authorId) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> getBookAuthors(int bookId) {
        try {
            return entityManager.createNativeQuery(GET_BOOK_AUTHORS_QUERY, Author.class)
                    .setParameter("bookId", bookId).getResultList();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
