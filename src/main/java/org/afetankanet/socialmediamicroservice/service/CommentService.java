package org.afetankanet.socialmediamicroservice.service;

import jakarta.transaction.Transactional;
import org.afetankanet.socialmediamicroservice.entity.CommentToSocialMediaContent;
import org.afetankanet.socialmediamicroservice.entity.ContentEntity;
import org.afetankanet.socialmediamicroservice.entity.User;
import org.afetankanet.socialmediamicroservice.model.CommentRequestModel;
import org.afetankanet.socialmediamicroservice.repository.jpa.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ContentService contentService;


    public CommentToSocialMediaContent saveComment(CommentRequestModel commentRequestModel) {
        CommentToSocialMediaContent commentToSocialMediaContent = new CommentToSocialMediaContent();

        User user = new User();
        user.setId(commentRequestModel.getUserId());

        ContentEntity contentEntity = new ContentEntity();
        contentEntity.setId(commentRequestModel.getContentId());


        commentToSocialMediaContent.setCommentText(commentRequestModel.getCommentText());
        commentToSocialMediaContent.setUser(user);
        commentToSocialMediaContent.setContent(contentEntity);
        contentService.evictContent();
        return commentRepository.save(commentToSocialMediaContent);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public CommentToSocialMediaContent getComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }
}
