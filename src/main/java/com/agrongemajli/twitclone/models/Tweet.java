package com.agrongemajli.twitclone.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tweetID;

    private String tweetData;

    @ManyToOne
    @JsonIgnore
    private User userT;

    @CreatedDate
    private Date tweetDateCreated;

    @OneToMany(mappedBy = "tweet")
    private List<Like> tweetLikes;




}
