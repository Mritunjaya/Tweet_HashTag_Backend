package com.tweet.hashtags.twitter;

import java.util.List;

public class TweetModel {
    private String screenName;
    private String text;
    private List<MediaModel> media;


    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MediaModel> getMedia() {
        return media;
    }

    public void setMedia(List<MediaModel> media) {
        this.media = media;
    }

    /*System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
    System.out.println("Media URL " + m.getMediaURL()); //get your url!
                System.out.println("Get Type " + m.getType());*/

}
