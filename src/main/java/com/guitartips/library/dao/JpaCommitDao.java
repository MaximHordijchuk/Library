package com.guitartips.library.dao;

import com.guitartips.library.domain.Commit;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by max on 25.03.15.
 * Have fun!
 */
@Repository
public class JpaCommitDao implements CommitDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCommit(Commit commit) {
        entityManager.persist(commit);
    }

    @Override
    public Commit getCommitById(String username, int bookId) {
        return entityManager.find(Commit.class, new Commit.CommitKey(username, bookId));
    }

    @Override
    public void updateCommit(Commit commit) {
        entityManager.merge(commit);
    }

    @Override
    public void removeBook(String username, int bookId) {
        Commit commit = entityManager.find(Commit.class, new Commit.CommitKey(username, bookId));
        entityManager.remove(commit);
    }
}
