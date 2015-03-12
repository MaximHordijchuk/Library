package com.guitartips.library.service;

import com.guitartips.library.domain.Author;

/**
 * Created by max on 01.03.15.
 * Have fun!
 */
public interface AuthorService {

    public void addAuthor(Author author);

    public Author getAuthorById(int authorId);

    public void updateAuthor(Author author);

    public void removeAuthor(int authorId);

}
