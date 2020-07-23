package com.agrongemajli.twitclone.repositories;


import com.agrongemajli.twitclone.models.AuthUser;
import com.agrongemajli.twitclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<AuthUser, UUID> {

    Optional<AuthUser> findByUsername(String userName);


}
