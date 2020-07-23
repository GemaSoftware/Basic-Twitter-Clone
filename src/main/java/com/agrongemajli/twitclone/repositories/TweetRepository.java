package com.agrongemajli.twitclone.repositories;

import com.agrongemajli.twitclone.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, UUID> {

    List<Tweet> findTweetsByUserT_UserPrivate(Boolean userPrivate);

    List<Tweet> findAllByOrderByTweetDateCreatedDesc();
}
