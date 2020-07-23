package com.agrongemajli.twitclone.services;

import com.agrongemajli.twitclone.interfaces.UserService;
import com.agrongemajli.twitclone.models.AuthUser;
import com.agrongemajli.twitclone.models.Role;
import com.agrongemajli.twitclone.repositories.AuthRepository;
import com.agrongemajli.twitclone.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(AuthUser authUser) {
        authUser.setPassword(bCryptPasswordEncoder.encode(authUser.getPassword()));
        authUser.setRoles(new ArrayList<>(roleRepository.findAll()));
        authRepository.save(authUser);
    }

    @Override
    public AuthUser findByUsername(String username) {
        return authRepository.findByUsername(username).orElse(null);
    }
}
