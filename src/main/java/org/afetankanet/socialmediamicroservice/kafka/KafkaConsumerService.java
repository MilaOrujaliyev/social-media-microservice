package org.afetankanet.socialmediamicroservice.kafka;

import org.afetankanet.socialmediamicroservice.converter.ContentConverter;
import org.afetankanet.socialmediamicroservice.entity.ContentEntity;
import org.afetankanet.socialmediamicroservice.model.Tweet;
import org.afetankanet.socialmediamicroservice.service.ContentSearchService;
import org.afetankanet.socialmediamicroservice.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    private final ContentService contentService;

    private final ContentSearchService contentSearchService;
    @Autowired
    public KafkaConsumerService(ContentService contentService, ContentSearchService contentSearchService) {
        this.contentService = contentService;
        this.contentSearchService = contentSearchService;
    }

    @KafkaListener(topics = "tweet_topic", groupId = "tweet_group_id")
    public void consume(Tweet tweet) {
        logger.info("Consumed message: " + tweet.toString());

        ContentEntity contentEntity = ContentConverter.convertToEntity(tweet);
        ContentEntity contentEntityInserted = contentService.saveContent(contentEntity);
        if(contentEntityInserted !=null ){
            contentSearchService.save(contentEntityInserted); // ElasticSearch'e kayıt
        }


    }
}
