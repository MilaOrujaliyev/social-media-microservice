package org.afetankanet.socialmediamicroservice.model;

public class UserLikeDislikeRequestModel {
    private Long userId;
    private Long contentId;

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
