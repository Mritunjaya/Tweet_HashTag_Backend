package com.tweet.hashtags.twitter;

import com.tweet.hashtags.util.ApplicationResponse;
import com.tweet.hashtags.util.MapBuilder;
import org.springframework.web.bind.annotation.*;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;


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

            TweetModel tweetModel = new TweetModel();

            tweetModel.setScreenName(status.getUser().getScreenName());
            tweetModel.setText(status.getText());

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
