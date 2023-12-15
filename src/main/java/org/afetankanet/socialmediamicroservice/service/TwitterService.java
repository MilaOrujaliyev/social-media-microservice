package org.afetankanet.socialmediamicroservice.service;

import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

@Service
public class TwitterService {
    private Twitter twitter;

    public TwitterService() {
        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("ocGWRvGf0jVUj3ZJoPvaX8Pm7")
                .setOAuthConsumerSecret("mW8g3y1HywgwX3lzZLsKsQkRvqvpFmpEIGYHqS9sWhWO7MAk2y")
                .setOAuthAccessToken("1676128400329564161-P2dvSlvHHI8D0xj2h9HhgSsEHaiGJw")
                .setOAuthAccessTokenSecret("ni28o1a69oc1mLtHdz3F26AOj4V65vUZldE17R83xYvpQ");

        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
    }

    public List<Status> searchTweets(String keyword) {
        try {
            Query query = new Query(keyword);
            query.setCount(2); // Aranacak tweet sayısını ayarlayabilirsiniz, örnek olarak 100
            QueryResult result = twitter.search(query);
            return result.getTweets();
        } catch (TwitterException e) {
            e.printStackTrace();
            return null; // Hata durumunda null dönüyoruz, alternatif olarak özel bir hata yönetimi yapılabilir.
        }
    }
}
