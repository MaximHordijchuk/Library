package com.guitartips.library.dao;

import com.guitartips.library.domain.Author;

import java.util.List;

/**
 * Created by max on 01.03.15.
 * Have fun!
 */
public interface AuthorDao {

    public void addAuthor(Author author);

    public Author getAuthorById(int authorId);

    public void updateAuthor(Author author);

    public void removeAuthor(int authorId);

    public List<Author> getBookAuthors(int bookId);
}
