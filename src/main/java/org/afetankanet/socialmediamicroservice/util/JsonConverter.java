package org.afetankanet.socialmediamicroservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.afetankanet.socialmediamicroservice.model.TweetResponse;

public class JsonConverter {

    /**
     * JSON string'ini TweetResponse nesnesine dönüştürür.
     *
     * @param json JSON metni
     * @return TweetResponse nesnesi
     * @throws JsonProcessingException JSON işleme hatası durumunda fırlatılır
     */
    public static TweetResponse convertJsonToTweetResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, TweetResponse.class);
    }
}

