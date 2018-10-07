package com.tweet.hashtags.twitter;

import lombok.Data;

@Data
public class MediaModel {

    private String mediaURL;
    private String mediaType;
    private String mediaDisplayURL;

    public String getMediaURL() {
        return mediaURL;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaDisplayURL() {
        return mediaDisplayURL;
    }

    public void setMediaDisplayURL(String mediaDisplayURL) {
        this.mediaDisplayURL = mediaDisplayURL;
    }

    /*System.out.println("Media URL " + m.getMediaURL()); //get your url!
                System.out.println("Get Type " + m.getType());
                System.out.println("Display URL " + m.getDisplayURL());*/
}
