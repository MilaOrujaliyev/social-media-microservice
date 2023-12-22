package org.afetankanet.socialmediamicroservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.afetankanet.socialmediamicroservice.kafka.KafkaProducerService;
import org.afetankanet.socialmediamicroservice.model.Tweet;
import org.afetankanet.socialmediamicroservice.model.TweetResponse;
import org.afetankanet.socialmediamicroservice.util.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TwitterApiService {
    private final RestTemplate restTemplate;
    private final KafkaProducerService kafkaProducerService;
    private final String apiUrl = "https://twitter-api45.p.rapidapi.com/search.php?query=deprem";

    @Autowired
    public TwitterApiService(KafkaProducerService kafkaProducerService) {
        this.restTemplate = new RestTemplate();
        this.kafkaProducerService = kafkaProducerService;
    }

    @Scheduled(fixedRate = 10000000) // 10 saniyede bir çalışacak şekilde ayarlandı
    public void fetchAndSendTweets() throws JsonProcessingException {
        System.out.println("fetchAndSendTweets Scheduled service started");
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "a88e38919fmsh939460868d0ca86p128b47jsn3dbc5a8f1a50");
        headers.set("X-RapidAPI-Host", "twitter-api45.p.rapidapi.com");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> response= restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                String.class
        );

        System.out.println(response.getBody());

        if (response.getStatusCode() == HttpStatus.OK) {
            String jsonResponse = response.getBody();
            jsonResponse = jsonResponse.replace("\"media\":[]", "\"media\":{}");

            System.out.println(jsonResponse);

            // JSON String'ini TweetResponse nesnesine dönüştür
            TweetResponse tweetResponse = JsonConverter.convertJsonToTweetResponse(jsonResponse);

            if (tweetResponse != null && tweetResponse.getTimeline() != null) {
                for (Tweet tweet : tweetResponse.getTimeline()) {
                    kafkaProducerService.sendTweet("tweet_topic", tweet);
                    System.out.println("produced: "+tweet);
                }
            }

        }


        System.out.println("fetchAndSendTweets Scheduled service end");
    }
}
