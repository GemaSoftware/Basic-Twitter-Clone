package com.agrongemajli.twitclone.services;

import com.agrongemajli.twitclone.models.AuthUser;
import com.agrongemajli.twitclone.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserService {

    @Autowired
    private AuthRepository authRepository;

    public boolean findByUsername(String userName){
        return authRepository.findByUsername(userName).isPresent();
    }



}
