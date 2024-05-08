package org.afetankanet.socialmediamicroservice.model;

import java.io.Serializable;

public class PhotoDTO implements Serializable {
    private Long id;
    private String mediaUrlHttps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMediaUrlHttps() {
        return mediaUrlHttps;
    }

    public void setMediaUrlHttps(String mediaUrlHttps) {
        this.mediaUrlHttps = mediaUrlHttps;
    }
}
