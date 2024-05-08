package org.afetankanet.socialmediamicroservice.converter;

import org.afetankanet.socialmediamicroservice.entity.*;
import org.afetankanet.socialmediamicroservice.model.*;
import java.util.stream.Collectors;

public class ContentConverterDTO {

    public static ContentDTO convertToDTO(ContentEntity contentEntity) {
        ContentDTO dto = new ContentDTO();
        dto.setId(contentEntity.getId());
        dto.setType(contentEntity.getType());
        dto.setTweetId(contentEntity.getTweetId());
        dto.setScreenName(contentEntity.getScreenName());
        dto.setBookmarks(contentEntity.getBookmarks());
        dto.setFavorites(contentEntity.getFavorites());
        dto.setCreatedAt(contentEntity.getCreatedAt());
        dto.setText(contentEntity.getText());
        dto.setLang(contentEntity.getLang());
        dto.setQuotes(contentEntity.getQuotes());
        dto.setReplies(contentEntity.getReplies());
        dto.setRetweets(contentEntity.getRetweets());
        dto.setViews(contentEntity.getViews());
        dto.setQueryCriteria(contentEntity.getQueryCriteria());
        dto.setLikes(contentEntity.getLikes());
        dto.setDislikes(contentEntity.getDislikes());

        if (contentEntity.getUserInfo() != null) {
            dto.setUserInfo(convertUserInfoToDTO(contentEntity.getUserInfo()));
        }

        if (contentEntity.getMedia() != null) {
            dto.setMedia(convertMediaToDTO(contentEntity.getMedia()));
        }

        if (contentEntity.getComments() != null) {
            dto.setComments(contentEntity.getComments().stream()
                    .map(ContentConverterDTO::convertCommentToDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    private static UserInfoDTO convertUserInfoToDTO(UserInfoEntity userInfo) {
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(userInfo.getId());
        dto.setScreenName(userInfo.getScreenName());
        dto.setName(userInfo.getName());
        dto.setFollowersCount(userInfo.getFollowersCount());
        dto.setFavouritesCount(userInfo.getFavouritesCount());
        dto.setAvatar(userInfo.getAvatar());
        dto.setVerified(userInfo.isVerified());
        dto.setFriendsCount(userInfo.getFriendsCount());
        return dto;
    }

    private static MediaDTO convertMediaToDTO(MediaEntity media) {
        MediaDTO dto = new MediaDTO();
        dto.setId(media.getId());
        dto.setPhotos(media.getPhotos().stream()
                .map(ContentConverterDTO::convertPhotoToDTO)
                .collect(Collectors.toList()));
        dto.setVideos(media.getVideos().stream()
                .map(ContentConverterDTO::convertVideoToDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public static PhotoDTO convertPhotoToDTO(PhotoEntity photo) {
        PhotoDTO dto = new PhotoDTO();
        dto.setId(photo.getId());
        dto.setMediaUrlHttps(photo.getMediaUrlHttps());
        return dto;
    }

    private static VideoDTO convertVideoToDTO(VideoEntity video) {
        VideoDTO dto = new VideoDTO();
        dto.setId(video.getId());
        dto.setMediaUrlHttps(video.getMediaUrlHttps());
        dto.setVariants(video.getVariants().stream()
                .map(ContentConverterDTO::convertVariantToDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private static VariantDTO convertVariantToDTO(VariantEntity variant) {
        VariantDTO dto = new VariantDTO();
        dto.setId(variant.getId());
        dto.setBitrate(variant.getBitrate());
        dto.setContentType(variant.getContentType());
        dto.setUrl(variant.getUrl());
        return dto;
    }

    private static CommentDTO convertCommentToDTO(CommentToSocialMediaContent comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setCommentText(comment.getCommentText());
        dto.setUserId(comment.getUser().getId()); // Assuming User object is eagerly fetched or otherwise managed
        dto.setContentId(comment.getContent().getId()); // Assuming Content object is available
        return dto;
    }
}
