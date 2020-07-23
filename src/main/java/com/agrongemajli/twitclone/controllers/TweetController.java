package com.agrongemajli.twitclone.controllers;

import com.agrongemajli.twitclone.models.*;
import com.agrongemajli.twitclone.repositories.AuthRepository;
import com.agrongemajli.twitclone.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private AuthRepository authRepository;



    @GetMapping("/create")
    public String addNewTweet(Model model){
        model.addAttribute("tweet", new Tweet());
        return "createtweet";
    }

    @PostMapping("/create")
    public String addNewTweet(@ModelAttribute("tweetdata") Tweet tweet, BindingResult bindingResult, Authentication authentication){
        if(bindingResult.hasErrors()){
            return "createtweet";
        }

        SpringUser springUser = (SpringUser) authentication.getPrincipal();
        AuthUser authUser = authRepository.findByUsername(springUser.getUsername()).orElse(null);

        if(authUser == null){
            return "createtweet";
        } else {
            tweet.setUserT(authUser.getUser());
            tweet.setTweetDateCreated(new Date());
            tweet.setTweetLikes(new ArrayList<Like>());
            tweetRepository.save(tweet);
        }

        return "redirect:/";
    }



}
