package com.guitartips.library.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 02.02.15.
 * Have fun!
 */
@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Transient
    private List<Author> authors = new ArrayList<>();

    public String getAuthorsString() {
        if (authors == null || authors.size() == 0) {
            return "";
        }
        StringBuilder authorsString = new StringBuilder();
        for (int i = 0; i < authors.size() - 1; i++) {
            authorsString.append(authors.get(i).getName() + ", ");
        }
        authorsString.append(authors.get(authors.size() - 1).getName());
        return authorsString.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
