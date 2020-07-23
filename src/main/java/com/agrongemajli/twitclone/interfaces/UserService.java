package com.agrongemajli.twitclone.interfaces;

import com.agrongemajli.twitclone.models.AuthUser;

public interface UserService {

    void save(AuthUser authUser);

    AuthUser findByUsername(String username);
}
