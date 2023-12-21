package org.afetankanet.socialmediamicroservice.model;

import java.util.List;

public class Media {
    private List<Photo> photo;
    private List<Video> video;

    // Photo ve Video iç sınıfları ve Getter/Setter metodları


    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }

    public static class Photo {
        private String media_url_https;

        // Getter ve Setter metodları


        public String getMedia_url_https() {
            return media_url_https;
        }

        public void setMedia_url_https(String media_url_https) {
            this.media_url_https = media_url_https;
        }
    }

    public static class Video {
        private String media_url_https;
        private List<Variant> variants;

        // Variant iç sınıfı ve Getter/Setter metodları


        public String getMedia_url_https() {
            return media_url_https;
        }

        public void setMedia_url_https(String media_url_https) {
            this.media_url_https = media_url_https;
        }

        public List<Variant> getVariants() {
            return variants;
        }

        public void setVariants(List<Variant> variants) {
            this.variants = variants;
        }

        public static class Variant {
            private int bitrate;
            private String content_type;
            private String url;

            // Getter ve Setter metodları


            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public String getContent_type() {
                return content_type;
            }

            public void setContent_type(String content_type) {
                this.content_type = content_type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
