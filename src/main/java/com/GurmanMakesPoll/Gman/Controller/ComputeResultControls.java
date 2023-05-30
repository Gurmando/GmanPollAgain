package com.GurmanMakesPoll.Gman.Controller;

import com.GurmanMakesPoll.Gman.DTO.OptionCount;
import com.GurmanMakesPoll.Gman.DTO.VoteResult;
import com.GurmanMakesPoll.Gman.Model.Vote;
import com.GurmanMakesPoll.Gman.Repository.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ComputeResultControls {

    @Autowired
    private VoteRepo voteRepository;

    int totalVotes = 0;
    Map<Long, OptionCount> tempMap = new HashMap<>();

    @PostMapping("/computeresult")
    public void computeResult(@PathVariable Long pollId, @RequestBody Vote vote) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);

        for (Vote v : allVotes) {
            totalVotes++;
            OptionCount optionCount = tempMap.get(v.getOption().getId());
            if (optionCount == null) {
                optionCount = new OptionCount();
                optionCount.setOptionId(v.getOption().getId());
                tempMap.put(v.getOption().getId(), optionCount);
            }
            optionCount.setCount(optionCount.getCount() + 1);
        }
        voteResult.setTotalVotes(totalVotes);
        voteResult.setResult(tempMap.values());
    }
}
