package org.afetankanet.socialmediamicroservice.model;

import java.util.List;

public class TweetResponse {
    private List<Tweet> timeline;
    private String next_cursor;

    // Getter ve Setter metodları


    public List<Tweet> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<Tweet> timeline) {
        this.timeline = timeline;
    }

    public String getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(String next_cursor) {
        this.next_cursor = next_cursor;
    }
}
