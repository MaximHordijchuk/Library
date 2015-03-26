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
    public Commit getCommitById(String username, int bookId) {
        return entityManager.find(Commit.class, new Commit.CommitKey(username, bookId));
    }

    @Override
    public void updateCommit(Commit commit) {
        entityManager.merge(commit);
    }
}
