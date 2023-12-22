package org.afetankanet.socialmediamicroservice.controller;

import org.afetankanet.socialmediamicroservice.entity.TweetEntity;
import org.afetankanet.socialmediamicroservice.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
    private final TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping
    public ResponseEntity<TweetEntity> createTweet(@RequestBody TweetEntity tweetEntity) {
        return ResponseEntity.ok(tweetService.saveTweet(tweetEntity));
    }

    @GetMapping
    public ResponseEntity<List<TweetEntity>> getAllTweets() {
        return ResponseEntity.ok(tweetService.findAllTweets());
    }

    @GetMapping("/paging")
    public ResponseEntity<Page<TweetEntity>> getAllTweetsWithPaging(@RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(tweetService.findAllTweetsWithPaging(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TweetEntity> getTweetById(@PathVariable Long id) {
        Optional<TweetEntity> tweet = tweetService.findTweetById(id);
        return tweet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTweet(@PathVariable Long id) {
        tweetService.deleteTweet(id);
        return ResponseEntity.ok().build();
    }
}
