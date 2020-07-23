package com.agrongemajli.twitclone.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


import java.util.Collection;
import java.util.UUID;


public class SpringUser extends User {

    // Here we add the extra fields of our users.
    private Long userID;

    @Getter
    @Setter
    private String fullName;


    public SpringUser(String username, String password, Collection<GrantedAuthority> authorities,
                      Long userid, String fullName) {
        super(username, password, authorities);
        this.userID = userid;
        this.fullName =fullName;
    }

    public SpringUser(String username, String password, Collection<GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


    public Long getUserID(){
        return userID;
    }

    public void setUserID(Long userID){
        this.userID = userID;
    }

}
