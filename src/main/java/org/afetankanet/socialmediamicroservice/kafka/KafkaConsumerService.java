package org.afetankanet.socialmediamicroservice.kafka;

import org.afetankanet.socialmediamicroservice.converter.TweetConverter;
import org.afetankanet.socialmediamicroservice.entity.TweetEntity;
import org.afetankanet.socialmediamicroservice.model.Tweet;
import org.afetankanet.socialmediamicroservice.service.TweetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    private final TweetService tweetService;
    @Autowired
    public KafkaConsumerService(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @KafkaListener(topics = "tweet_topic", groupId = "tweet_group_id")
    public void consume(Tweet tweet) {
        logger.info("Consumed message: " + tweet.toString());

        TweetEntity tweetEntity = TweetConverter.convertToEntity(tweet);
        tweetService.saveTweet(tweetEntity);

    }
}
