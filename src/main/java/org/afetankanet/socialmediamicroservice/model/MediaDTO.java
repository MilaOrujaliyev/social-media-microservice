package org.afetankanet.socialmediamicroservice.model;

import java.io.Serializable;
import java.util.List;

public class MediaDTO implements Serializable {
    private Long id;
    private List<PhotoDTO> photos;
    private List<VideoDTO> videos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PhotoDTO> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoDTO> photos) {
        this.photos = photos;
    }

    public List<VideoDTO> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoDTO> videos) {
        this.videos = videos;
    }
}
