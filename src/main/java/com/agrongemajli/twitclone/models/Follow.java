package com.agrongemajli.twitclone.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long followID;

    @ManyToOne
    private User from;

    @ManyToOne
    private  User to;

}
