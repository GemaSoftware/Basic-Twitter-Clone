package com.agrongemajli.twitclone.controllers;


import com.agrongemajli.twitclone.models.Tweet;
import com.agrongemajli.twitclone.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private TweetService tweetService;

    @GetMapping
    private String getHome(Model model) {
        model.addAttribute("tweets", tweetService.findAllSorted());
        return "index";
    }

}
