package com.organicfarmer.paezand.retrofitproject.data.model;

import com.google.gson.annotations.SerializedName;

public class Hit {
    @SerializedName("id")
    
    private Integer id;
    @SerializedName("pageURL")
    
    private String pageURL;
    @SerializedName("type")
    
    private String type;
    @SerializedName("tags")
    
    private String tags;
    @SerializedName("previewURL")
    
    private String previewURL;
    @SerializedName("previewWidth")
    
    private Integer previewWidth;
    @SerializedName("previewHeight")
    
    private Integer previewHeight;
    @SerializedName("webformatURL")
    
    private String webformatURL;
    @SerializedName("webformatWidth")
    
    private Integer webformatWidth;
    @SerializedName("webformatHeight")
    
    private Integer webformatHeight;
    @SerializedName("largeImageURL")
    
    private String largeImageURL;
    @SerializedName("fullHDURL")
    
    private String fullHDURL;
    @SerializedName("imageURL")
    
    private String imageURL;
    @SerializedName("imageWidth")
    
    private Integer imageWidth;
    @SerializedName("imageHeight")
    
    private Integer imageHeight;
    @SerializedName("imageSize")
    
    private Integer imageSize;
    @SerializedName("views")
    
    private Integer views;
    @SerializedName("downloads")
    
    private Integer downloads;
    @SerializedName("favorites")
    
    private Integer favorites;
    @SerializedName("likes")
    
    private Integer likes;
    @SerializedName("comments")
    
    private Integer comments;
    @SerializedName("user_id")
    
    private Integer userId;
    @SerializedName("user")
    
    private String user;
    @SerializedName("userImageURL")
    
    private String userImageURL;

    public Integer getId() {
        return id;
    }

    public String getPageURL() {
        return pageURL;
    }

    public String getType() {
        return type;
    }

    public String getTags() {
        return tags;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public Integer getPreviewWidth() {
        return previewWidth;
    }

    public Integer getPreviewHeight() {
        return previewHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public Integer getWebformatWidth() {
        return webformatWidth;
    }

    public Integer getWebformatHeight() {
        return webformatHeight;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public String getFullHDURL() {
        return fullHDURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public Integer getImageSize() {
        return imageSize;
    }

    public Integer getViews() {
        return views;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getComments() {
        return comments;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUser() {
        return user;
    }

    public String getUserImageURL() {
        return userImageURL;
    }
}
