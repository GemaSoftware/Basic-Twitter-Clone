package com.agrongemajli.twitclone.models;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "tabelLikes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likeID;

    @ManyToOne
    private Tweet tweet;

    @ManyToOne
    private User userL;

}
