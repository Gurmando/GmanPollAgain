package com.GurmanMakesPoll.Gman.Services;

import com.GurmanMakesPoll.Gman.Repository.PollRepo;
import org.apache.tomcat.jni.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicePoll {

    @Autowired
    private PollRepo repo;

    public Iterable<Poll> getAllPolls() {

        return repo.findAll();
    }

    public void addPoll(Poll poll){

        repo.save(poll);

    }

    public void deletePoll(Long pollID){

        repo.delete(new Poll());
    }

    public void editPoll(Long pollID, Poll poll){

        repo.save(poll);
    }

    public Optional<Poll> findPoll(Long pollID){
        return repo.findById(pollID);
    }
}
