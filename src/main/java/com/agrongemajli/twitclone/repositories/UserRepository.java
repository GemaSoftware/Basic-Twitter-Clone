package com.agrongemajli.twitclone.repositories;

import com.agrongemajli.twitclone.models.AuthUser;
import com.agrongemajli.twitclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findUserByAuthData_AuthID(Long authID);

    User findUserByFullNameContaining(String con);





}
