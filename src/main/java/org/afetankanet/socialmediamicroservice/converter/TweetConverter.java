package org.afetankanet.socialmediamicroservice.converter;

import org.afetankanet.socialmediamicroservice.model.*;
import org.afetankanet.socialmediamicroservice.entity.*;

import java.util.stream.Collectors;

public class TweetConverter {

    public static TweetEntity convertToEntity(Tweet tweet) {
        if (tweet == null) {
            return null;
        }

        TweetEntity tweetEntity = new TweetEntity();
        tweetEntity.setType(tweet.getType());
        tweetEntity.setTweetId(tweet.getTweet_id());
        tweetEntity.setScreenName(tweet.getScreen_name());
        tweetEntity.setBookmarks(tweet.getBookmarks());
        tweetEntity.setFavorites(tweet.getFavorites());
        tweetEntity.setCreatedAt(tweet.getCreated_at());
        tweetEntity.setText(tweet.getText());
        tweetEntity.setLang(tweet.getLang());
        tweetEntity.setQuotes(tweet.getQuotes());
        tweetEntity.setReplies(tweet.getReplies());
        tweetEntity.setRetweets(tweet.getRetweets());
        tweetEntity.setViews(tweet.getViews());
        tweetEntity.setUserInfo(convertUserInfoToEntity(tweet.getUser_info()));
        tweetEntity.setMedia(convertMediaToEntity(tweet.getMedia()));

        return tweetEntity;
    }

    private static UserInfoEntity convertUserInfoToEntity(UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setScreenName(userInfo.getScreen_name());
        userInfoEntity.setName(userInfo.getName());
        userInfoEntity.setFollowersCount(userInfo.getFollowers_count());
        userInfoEntity.setFavouritesCount(userInfo.getFavourites_count());
        userInfoEntity.setAvatar(userInfo.getAvatar());
        userInfoEntity.setVerified(userInfo.isVerified());
        userInfoEntity.setFriendsCount(userInfo.getFriends_count());

        return userInfoEntity;
    }

    private static MediaEntity convertMediaToEntity(Media media) {
        if (media == null) {
            return null;
        }

        MediaEntity mediaEntity = new MediaEntity();
        if (media.getPhoto() != null) {
            mediaEntity.setPhotos(media.getPhoto().stream()
                    .map(TweetConverter::convertPhotoToEntity)
                    .collect(Collectors.toList()));
        }
        if (media.getVideo() != null) {
            mediaEntity.setVideos(media.getVideo().stream()
                    .map(TweetConverter::convertVideoToEntity)
                    .collect(Collectors.toList()));
        }

        return mediaEntity;
    }

    private static PhotoEntity convertPhotoToEntity(Media.Photo photo) {
        if (photo == null) {
            return null;
        }

        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setMediaUrlHttps(photo.getMedia_url_https());

        return photoEntity;
    }

    private static VideoEntity convertVideoToEntity(Media.Video video) {
        if (video == null) {
            return null;
        }

        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setMediaUrlHttps(video.getMedia_url_https());
        if (video.getVariants() != null) {
            videoEntity.setVariants(video.getVariants().stream()
                    .map(TweetConverter::convertVariantToEntity)
                    .collect(Collectors.toList()));
        }

        return videoEntity;
    }

    private static VariantEntity convertVariantToEntity(Media.Video.Variant variant) {
        if (variant == null) {
            return null;
        }

        VariantEntity variantEntity = new VariantEntity();
        variantEntity.setBitrate(variant.getBitrate());
        variantEntity.setContentType(variant.getContent_type());
        variantEntity.setUrl(variant.getUrl());

        return variantEntity;
    }
}