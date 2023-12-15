package org.afetankanet.socialmediamicroservice.controller;

import org.afetankanet.socialmediamicroservice.service.TwitterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.Status;
import java.util.List;

@RestController
public class TwitterController {

    private final TwitterService twitterService;

    // Constructor Injection için TwitterService bağımlılığını enjekte ediyoruz
    public TwitterController(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    // Anahtar kelimeye göre tweet'leri arayan bir GET endpoint'i
    @GetMapping("/searchTweets")
    public List<Status> searchTweets(@RequestParam String keyword) {
        return twitterService.searchTweets(keyword);
    }
}
