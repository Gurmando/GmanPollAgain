package com.GurmanMakesPoll.Gman.Controller;

import com.GurmanMakesPoll.Gman.Services.ServicePoll;
import org.apache.tomcat.jni.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PollControls {

    @Autowired
    private ServicePoll pollServe;

    @GetMapping("/polls")
    public Iterable<Poll> getAllPolls() {

        return pollServe.getAllPolls();
    }

    @PostMapping("/polls")
    public void addNewPoll(@RequestBody Poll poll) {

        pollServe.addPoll(poll);
    }

    @PutMapping("/polls/{pollId}")
    public void createPoll(@RequestBody Poll poll) {

        pollServe.addPoll(poll);
    }

    @GetMapping("/polls/{pollId}")
    public Optional<Poll> getPoll(@PathVariable Long pollID) {
        return pollServe.findPoll(pollID);
    }


    @PutMapping("/polls/{pollId}")
    public void editPoll(@RequestBody Poll poll, @PathVariable Long pollId) {

        pollServe.editPoll(pollId, poll);
    }

    //deleting a poll
    @DeleteMapping("/polls/{pollId}")
    public void deleteThePoll(@PathVariable Long pollID) {
        pollServe.deletePoll(pollID);
    }
 }


