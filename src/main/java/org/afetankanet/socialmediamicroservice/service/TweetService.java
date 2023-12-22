package org.afetankanet.socialmediamicroservice.service;

import org.afetankanet.socialmediamicroservice.entity.TweetEntity;
import org.afetankanet.socialmediamicroservice.repository.TweetRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TweetService {
    private final TweetRepository tweetRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public TweetEntity saveTweet(TweetEntity tweetEntity) {
        try {
            return tweetRepository.save(tweetEntity);
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            System.out.println("ConstraintViolationException : The content is already exist ");
            return null;
        }

    }

    public List<TweetEntity> findAllTweets() {
        return tweetRepository.findAll(Sort.by("tweetId").descending());
    }

    public Page<TweetEntity> findAllTweetsWithPaging(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("tweetId").descending());
        return tweetRepository.findAll(pageable);
    }

    public Optional<TweetEntity> findTweetById(Long id) {
        return tweetRepository.findById(id);
    }

    public void deleteTweet(Long id) {
        tweetRepository.deleteById(id);
    }
}
