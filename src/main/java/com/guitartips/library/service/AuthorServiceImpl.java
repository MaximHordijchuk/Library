package com.guitartips.library.service;

import com.guitartips.library.domain.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by max on 01.03.15.
 * Have fun!
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    @Transactional
    public void addAuthor(Author author) {

    }

    @Override
    @Transactional
    public Author getAuthorById(int authorId) {
        return null;
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {

    }

    @Override
    @Transactional
    public void removeAuthor(int authorId) {

    }
}
