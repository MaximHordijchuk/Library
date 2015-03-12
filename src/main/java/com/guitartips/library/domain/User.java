package com.guitartips.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by max on 12.02.15.
 * Have fun!
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Column(name = "email", unique = true, nullable = false, length = 30)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
