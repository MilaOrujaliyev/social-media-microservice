package org.afetankanet.socialmediamicroservice.kafka;

import org.afetankanet.socialmediamicroservice.model.Tweet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "tweet_topic", groupId = "tweet_group_id")
    public void consume(Tweet tweet) {
        logger.info("Consumed message: " + tweet.toString());
        // Burada Tweet nesnesi ile ilgili işlemler yapılabilir.
    }
}
