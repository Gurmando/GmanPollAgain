package com.GurmanMakesPoll.Gman.Controller;

import com.GurmanMakesPoll.Gman.Model.Vote;
import com.GurmanMakesPoll.Gman.Repository.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoteControls {

    @Autowired
    private VoteRepo VoteRepository;

    @PostMapping("/polls/{pollId}/votes")
    public void createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        vote = VoteRepository.save(vote);
    }

    @GetMapping("/polls/{pollId}/votes")
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        return VoteRepository.findByPoll(pollId);
    }
}
