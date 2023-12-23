package org.afetankanet.socialmediamicroservice.model;

public class Tweet {
    private String type;
    private String tweet_id;
    private String screen_name;
    private int bookmarks;
    private int favorites;
    private String created_at;
    private String text;
    private String lang;
    private int quotes;
    private int replies;
    private int retweets;
    private String views;
    private UserInfo user_info;
    private Media media;

    private String queryCriteria;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTweet_id() {
        return tweet_id;
    }

    public void setTweet_id(String tweet_id) {
        this.tweet_id = tweet_id;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public int getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(int bookmarks) {
        this.bookmarks = bookmarks;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getQuotes() {
        return quotes;
    }

    public void setQuotes(int quotes) {
        this.quotes = quotes;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getRetweets() {
        return retweets;
    }

    public void setRetweets(int retweets) {
        this.retweets = retweets;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public UserInfo getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfo user_info) {
        this.user_info = user_info;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getQueryCriteria() {
        return queryCriteria;
    }

    public void setQueryCriteria(String queryCriteria) {
        this.queryCriteria = queryCriteria;
    }
}
