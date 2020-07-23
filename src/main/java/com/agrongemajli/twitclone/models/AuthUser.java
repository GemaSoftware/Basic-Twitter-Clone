package com.agrongemajli.twitclone.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authID;


    private String username;

    private String password;

    @OneToOne(mappedBy = "authData")
    private User user;

    private String fullName;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="user_role",
            joinColumns={@JoinColumn(name="AUTHUSER_ID", referencedColumnName="authID")},
            inverseJoinColumns={@JoinColumn(name="AUTHROLE_ID", referencedColumnName="roleID")})
    private List<Role> roles;

    public AuthUser(){}

}
