package com.guitartips.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by max on 23.03.15.
 * Have fun!
 */
@Entity
@Table(name = "USER_BOOK")
public class Commit {
    @Id
    @Column(name = "username", nullable = false, length = 15)
    private String username;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "date")
    private Date date;

    public Commit() {
    }

    public Commit(String username, int bookId, Date date, String comment) {
        this.username = username;
        this.bookId = bookId;
        this.date = date;
        this.comment = comment;
    }

    @Column(name = "comment")

    private String comment;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
