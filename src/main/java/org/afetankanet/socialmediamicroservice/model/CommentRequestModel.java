package org.afetankanet.socialmediamicroservice.model;

public class CommentRequestModel {
    private String commentText;
    private Long userId;
    private Long contentId;

    public CommentRequestModel() {}

    public CommentRequestModel(String commentText, Long userId, Long contentId) {
        this.commentText = commentText;
        this.userId = userId;
        this.contentId = contentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
}
