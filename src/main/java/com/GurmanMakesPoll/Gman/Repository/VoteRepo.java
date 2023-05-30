package com.GurmanMakesPoll.Gman.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.GurmanMakesPoll.Gman.Model.Vote;

public interface VoteRepo extends CrudRepository<Vote, Long> {

    @Query(value="select v.* from Option o, Vote v where o.POLL_ID = ?1 and v.OPTION_ID = o.OPTION_ID", nativeQuery = true)
    public Iterable<Vote> findByPoll(Long pollId);

}