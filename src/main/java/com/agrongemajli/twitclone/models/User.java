package com.agrongemajli.twitclone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String fullName;

    @JsonIgnore
    @Setter
    @OneToOne
    private AuthUser authData;

    private Boolean userPrivate;

    private String userHandle;

    @OneToMany(mappedBy = "userT")
    private List<Tweet> userTweets;

    @OneToMany(mappedBy = "userL")
    private List<Like> userLikes;

    @OneToMany(mappedBy = "to")
    private List<Follow> followers;

    @OneToMany(mappedBy = "from")
    private List<Follow> following;

    public User(String fullName){}


    public User(String username, String fullName) {
        this.fullName = fullName;
        this.userHandle = username;
        this.userPrivate = false;
    }

    public User(){}

}
