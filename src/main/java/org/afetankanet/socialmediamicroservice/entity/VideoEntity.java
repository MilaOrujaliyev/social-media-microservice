package org.afetankanet.socialmediamicroservice.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "videos")
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mediaUrlHttps;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VariantEntity> variants;

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

    public List<VariantEntity> getVariants() {
        return variants;
    }

    public void setVariants(List<VariantEntity> variants) {
        this.variants = variants;
    }
}