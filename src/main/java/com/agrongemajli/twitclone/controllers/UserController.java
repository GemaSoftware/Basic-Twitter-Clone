package com.agrongemajli.twitclone.controllers;

import com.agrongemajli.twitclone.models.AuthUser;
import com.agrongemajli.twitclone.models.SpringUser;
import com.agrongemajli.twitclone.models.User;
import com.agrongemajli.twitclone.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private AuthRepository authRepository;

    @GetMapping("/profile")
    private String getProfilePage(Model model, Authentication authentication){
        SpringUser springUser = (SpringUser) authentication.getPrincipal();
        User user = authRepository.findByUsername(springUser.getUsername()).orElse(null).getUser();

        if(user == null){
            return "403";
        } else {
            model.addAttribute("userData", user);
            
        }

        return "profile";
    }



}
