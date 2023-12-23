package org.afetankanet.socialmediamicroservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "photos")
public class PhotoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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