package com.GurmanMakesPoll.Gman.Repository;

import org.apache.tomcat.jni.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepo extends CrudRepository<Poll, Long> {

}
