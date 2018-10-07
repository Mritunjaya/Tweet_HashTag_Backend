package com.tweet.hashtags.twitter;

import java.util.List;

public class TwitterModel {

    private List<TweetModel> tweet;

    public List<TweetModel> getTweet() {
        return tweet;
    }

    public void setTweet(List<TweetModel> tweet) {
        this.tweet = tweet;
    }
}
