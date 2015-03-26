package com.guitartips.library.service;

import com.guitartips.library.dao.CommitDao;
import com.guitartips.library.domain.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by max on 25.03.15.
 * Have fun!
 */
@Service
public class CommitServiceImpl implements CommitService {

    @Autowired
    private CommitDao commitDao;

    @Override
    @Transactional
    public Commit getCommitById(String username, int bookId) {
        return commitDao.getCommitById(username, bookId);
    }

    @Override
    @Transactional
    public void updateCommit(Commit commit) {
        commitDao.updateCommit(commit);
    }
}
