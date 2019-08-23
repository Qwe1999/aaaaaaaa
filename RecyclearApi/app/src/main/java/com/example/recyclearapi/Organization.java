package com.example.recyclearapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Organization {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("profile_image_90")
    @Expose
    private String profileImage90;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileImage90() {
        return profileImage90;
    }

    public void setProfileImage90(String profileImage90) {
        this.profileImage90 = profileImage90;
    }

}