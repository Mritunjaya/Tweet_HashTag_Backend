package com.tweet.hashtags.twitter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import twitter4j.GeoLocation;

public class TweetModel {
    
	private String screenName;
    private String text;
    private List<MediaModel> media;
    private String createdDt;
    private GeoLocation loctn;
    private String city;
    private String country;


    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

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
    
    public String getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(String createdDt) {
		this.createdDt = createdDt;
	}

	public GeoLocation getLoctn() {
		return loctn;
	}

	public void setLoctn(GeoLocation loctn) {
		this.loctn = loctn;
	}

    /*System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
    System.out.println("Media URL " + m.getMediaURL()); //get your url!
                System.out.println("Get Type " + m.getType());*/

}
