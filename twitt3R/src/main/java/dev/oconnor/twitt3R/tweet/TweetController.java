package dev.oconnor.twitt3R.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
    @Autowired
    TweetService service;

    @GetMapping("")
    List<Tweet> allTweets(){
        return service.allTweets();
    }

    @PostMapping("")
    ResponseEntity<Tweet> addTweet(@RequestBody Tweet t){
        service.addTweet(t);

        return new ResponseEntity<>(t, HttpStatus.OK);
    }
}
