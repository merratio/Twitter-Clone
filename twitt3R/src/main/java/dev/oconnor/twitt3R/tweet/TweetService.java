package dev.oconnor.twitt3R.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {
    @Autowired
    TweetRepository repo;

    public List<Tweet> allTweets(){
        return repo.findAll();
    }

    public void addTweet(Tweet t){
        repo.save(t);
    }

    public boolean deleteTweet(long id){
        if(repo.findById(id).isPresent()){
            return false;
        }

        repo.deleteById(id);

        return true;
    }
}
