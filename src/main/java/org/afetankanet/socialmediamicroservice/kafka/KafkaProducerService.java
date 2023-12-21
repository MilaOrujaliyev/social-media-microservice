package org.afetankanet.socialmediamicroservice.kafka;

import org.afetankanet.socialmediamicroservice.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, Tweet> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Tweet> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTweet(String topic, Tweet tweet) {
        kafkaTemplate.send(topic, tweet);
    }
}
