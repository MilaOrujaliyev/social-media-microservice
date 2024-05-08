package org.afetankanet.socialmediamicroservice.service;

import org.afetankanet.socialmediamicroservice.entity.ContentEntity;
import org.afetankanet.socialmediamicroservice.entity.User;
import org.afetankanet.socialmediamicroservice.entity.UserLikeDislike;
import org.afetankanet.socialmediamicroservice.model.UserLikeDislikeRequestModel;
import org.afetankanet.socialmediamicroservice.repository.jpa.ContentRepository;
import org.afetankanet.socialmediamicroservice.repository.jpa.UserLikeDislikeRepository;
import org.afetankanet.socialmediamicroservice.repository.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeDislikeService {

    private final ContentRepository contentRepository;
    private final UserLikeDislikeRepository userLikeDislikeRepository;

    private final UserRepository userRepository;

    private final ContentService contentService;

    public LikeDislikeService(ContentRepository contentRepository, UserLikeDislikeRepository userLikeDislikeRepository, UserRepository userRepository, ContentService contentService) {
        this.contentRepository = contentRepository;
        this.userLikeDislikeRepository = userLikeDislikeRepository;
        this.userRepository = userRepository;
        this.contentService = contentService;
    }


    public void addLike(UserLikeDislikeRequestModel request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ContentEntity content = contentRepository.findById(request.getContentId())
                .orElseThrow(() -> new RuntimeException("Content not found"));
        handleVote(user, content, "like");
    }

    public void addDislike(UserLikeDislikeRequestModel request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ContentEntity content = contentRepository.findById(request.getContentId())
                .orElseThrow(() -> new RuntimeException("Content not found"));
        handleVote(user, content, "dislike");
    }

    private void handleVote(User user, ContentEntity content, String voteType) {

        Optional<UserLikeDislike> existingVote = userLikeDislikeRepository.findByUserAndContent(user, content);
        if (existingVote.isPresent()) {
            if (!existingVote.get().getVoteType().equals(voteType)) {
                if (voteType.equals("like")) {
                    content.setDislikes(content.getDislikes() - 1);
                    content.setLikes(content.getLikes() + 1);
                } else {
                    content.setLikes(content.getLikes() - 1);
                    content.setDislikes(content.getDislikes() + 1);
                }
                existingVote.get().setVoteType(voteType);
            }
        } else {
            UserLikeDislike newVote = new UserLikeDislike();
            newVote.setUser(user);
            newVote.setContent(content);
            newVote.setVoteType(voteType);
            userLikeDislikeRepository.save(newVote);
            if (voteType.equals("like")) {
                content.setLikes(content.getLikes() + 1);
            } else {
                content.setDislikes(content.getDislikes() + 1);
            }
        }
        contentService.evictContent();
        contentRepository.save(content);
    }

}
