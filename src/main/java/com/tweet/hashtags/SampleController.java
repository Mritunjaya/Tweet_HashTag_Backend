package com.tweet.hashtags;

import com.tweet.hashtags.util.ApplicationResponse;
import com.tweet.hashtags.util.MapBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/name")
    public ApplicationResponse getName() {
        return ApplicationResponse.success(MapBuilder.of("K1", "V1"));
    }
}
