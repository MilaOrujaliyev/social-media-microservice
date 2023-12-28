package org.afetankanet.socialmediamicroservice.converter;

import org.afetankanet.socialmediamicroservice.model.*;
import org.afetankanet.socialmediamicroservice.entity.*;

import java.util.stream.Collectors;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.afetankanet.socialmediamicroservice.converter.DateConverter.convertDateToLocalDateTime;

public class ContentConverter {

    public static ContentEntity convertToEntity(Tweet tweet) {
        if (tweet == null) {
            return null;
        }

        ContentEntity contentEntity = new ContentEntity();
        contentEntity.setType(tweet.getType());
        contentEntity.setTweetId(tweet.getTweet_id());
        contentEntity.setScreenName(tweet.getScreen_name());
        contentEntity.setBookmarks(tweet.getBookmarks());
        contentEntity.setFavorites(tweet.getFavorites());

        contentEntity.setCreatedAt(DateConverter.convertStringToDate(tweet.getCreated_at()));

        contentEntity.setText(tweet.getText());
        contentEntity.setLang(tweet.getLang());
        contentEntity.setQuotes(tweet.getQuotes());
        contentEntity.setReplies(tweet.getReplies());
        contentEntity.setRetweets(tweet.getRetweets());
        contentEntity.setViews(tweet.getViews());
        contentEntity.setUserInfo(convertUserInfoToEntity(tweet.getUser_info()));
        contentEntity.setMedia(convertMediaToEntity(tweet.getMedia()));
        contentEntity.setQueryCriteria(tweet.getQueryCriteria());

        return contentEntity;
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
                    .map(ContentConverter::convertPhotoToEntity)
                    .collect(Collectors.toList()));
        }
        if (media.getVideo() != null) {
            mediaEntity.setVideos(media.getVideo().stream()
                    .map(ContentConverter::convertVideoToEntity)
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
                    .map(ContentConverter::convertVariantToEntity)
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