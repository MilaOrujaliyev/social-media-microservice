package org.afetankanet.socialmediamicroservice.model;

import java.io.Serializable;
import java.util.List;

public class VideoDTO implements Serializable {
    private Long id;
    private String mediaUrlHttps;
    private List<VariantDTO> variants;

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

    public List<VariantDTO> getVariants() {
        return variants;
    }

    public void setVariants(List<VariantDTO> variants) {
        this.variants = variants;
    }
}
