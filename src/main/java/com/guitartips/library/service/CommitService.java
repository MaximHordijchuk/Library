package com.guitartips.library.service;

import com.guitartips.library.domain.Commit;

/**
 * Created by max on 25.03.15.
 * Have fun!
 */
public interface CommitService {

    public Commit getCommitById(String username, int bookId);

    public void updateCommit(Commit commit);

}
