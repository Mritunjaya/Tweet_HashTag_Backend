package com.tweet.hashtags.twitter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweet.hashtags.util.ApplicationResponse;
import com.tweet.hashtags.util.MapBuilder;

import org.apache.tomcat.jni.Address;
import org.springframework.web.bind.annotation.*;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


@RestController
@RequestMapping("/tweets")
public class TwitterController {

    /*@GetMapping("/getNames")
    public ApplicationResponse getName () throws Exception{
        TwitterModel resultTwitterModel = getTweetDetails();
        return ApplicationResponse.success(MapBuilder.of("twitter", resultTwitterModel.getTweet()));

    }*/

    @CrossOrigin()
    @GetMapping("/details/{hashTag}")
    private ApplicationResponse getTweetDetails(@PathVariable String hashTag) throws Exception {

        System.out.println("ENTER : getImages");
        System.out.println("Hash Tag : " + hashTag);
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey("6pJBB04936xwZok4V7PzDEynN")
                .setOAuthConsumerSecret("sBYdQ8aO8hkY9tq5pLAXCjRsVRY95LcJZqkvsnWPOhBEtkbcSe")
                .setOAuthAccessToken("54989865-LM2tjEuiNddSkJqu3TSagcB66h8KSKq2hDEuxJSDA")
                .setOAuthAccessTokenSecret("7ouHtcIOCdFJHm5eP8s3oVGQDIG6Ejgiim5AqVOKx0JYY");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        //Query query = new Query("#INDvWI");
        Query query = new Query(hashTag);
        QueryResult result = twitter.search(query);

        System.out.println("RETURN : getImages");

        List<TweetModel> tweetList = new ArrayList<>();

        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            MediaEntity[] media = status.getMediaEntities(); //get the media entities from the status
            System.out.println("Get Id : " + status.getId());
            System.out.println("Get retweet count: " + status.getRetweetCount());
            String city="";
            String country="";
            TweetModel tweetModel = new TweetModel();

            tweetModel.setScreenName(status.getUser().getName());
            tweetModel.setText(status.getText());
            Date dt=status.getCreatedAt();
            Timestamp ts=new Timestamp(dt.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date= formatter.format(ts);
            System.out.println("TIME AFTER FORMAT ==="+date);
            tweetModel.setCreatedDt(date);
            if(status.getPlace()!=null){
		           country=status.getPlace().getCountry();
		           city=status.getPlace().getFullName();
		            System.out.println("CITY & COUNTRY ==="+city+" , "+country);
            }
            else {
            	city="Bangalore";
            	country="India";	
            }
            tweetModel.setCity(city);
            tweetModel.setCountry(country);
            List<MediaModel> mediaList = new ArrayList<>();

            for(MediaEntity m : media){ //search trough your entities
                System.out.println("Media URL " + m.getMediaURL()); //get your url!
                System.out.println("Get Type " + m.getType());
                System.out.println("Display URL " + m.getDisplayURL());

                MediaModel mediaModel = new MediaModel();
                mediaModel.setMediaURL(m.getMediaURL());
                mediaModel.setMediaType(m.getType());
                mediaModel.setMediaDisplayURL(m.getDisplayURL());
                mediaList.add(mediaModel);
            }

            tweetModel.setMedia(mediaList);
            tweetList.add(tweetModel);
        }

        TwitterModel twitterModel = new TwitterModel();

        twitterModel.setTweet(tweetList);

        System.out.println("RETURN : getImages");
        //return twitterModel;
        return ApplicationResponse.success(MapBuilder.of("twitter", twitterModel.getTweet()));

    }
}
