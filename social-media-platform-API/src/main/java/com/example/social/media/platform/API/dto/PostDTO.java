package com.example.social.media.platform.API.dto;

public class PostDTO {

    private String content;
    private String imageUrl; // or List<String> imageUrls for multiple images

    // getters and setters

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
