package com.agrongemajli.twitclone.services;


import com.agrongemajli.twitclone.models.Tweet;
import com.agrongemajli.twitclone.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TweetService {

@Autowired private TweetRepository tweetRepository;

public List<Tweet> findAllPublicTweets(){
    return tweetRepository.findAll();
}


    public List<Tweet> findAllSorted() {
        return tweetRepository.findAllByOrderByTweetDateCreatedDesc();
    }
}
