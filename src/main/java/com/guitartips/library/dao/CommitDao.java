package com.guitartips.library.dao;

import com.guitartips.library.domain.Commit;

/**
 * Created by max on 25.03.15.
 * Have fun!
 */
public interface CommitDao {

    public Commit getCommitById(String username, int bookId);

    public void updateCommit(Commit commit);

}
