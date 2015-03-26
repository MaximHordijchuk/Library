package com.guitartips.library.dao;

import com.guitartips.library.domain.Commit;
import com.guitartips.library.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by max on 16.02.15.
 * Have fun!
 */
@Repository
public class JpaUserDao implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(String username) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Commit> getUserCommits(String username) {
        try {
            User user = entityManager.find(User.class, username);
            List<Commit> commits = user.getCommits();
            commits.size();
            return commits;
        } catch (PersistenceException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void addBook(Commit commit) {
        try {
            entityManager.persist(commit);
        } catch (PersistenceException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
