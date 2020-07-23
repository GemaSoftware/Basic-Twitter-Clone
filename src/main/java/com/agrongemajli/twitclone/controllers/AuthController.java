package com.agrongemajli.twitclone.controllers;

import com.agrongemajli.twitclone.interfaces.UserService;
import com.agrongemajli.twitclone.models.AuthUser;
import com.agrongemajli.twitclone.models.User;
import com.agrongemajli.twitclone.repositories.UserRepository;
import com.agrongemajli.twitclone.services.AuthUserService;
import com.agrongemajli.twitclone.services.UserServiceImpl;
import com.agrongemajli.twitclone.services.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AuthController {
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registration(Model model) {

        model.addAttribute("userForm", new AuthUser());
        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") AuthUser userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.save(userForm);
        User user = new User(userForm.getUsername(), userForm.getFullName());
        user.setAuthData(userForm);
        userRepository.save(user);
        return "redirect:/";
    }

}
