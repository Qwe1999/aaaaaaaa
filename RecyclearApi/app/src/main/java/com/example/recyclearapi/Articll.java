package com.example.recyclearapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Articll {

    @SerializedName("type_of")
    @Expose
    private String typeOf;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("cover_image")
    @Expose
    private String coverImage;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("tag_list")
    @Expose
    private List<String> tagList = null;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("canonical_url")
    @Expose
    private String canonicalUrl;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("positive_reactions_count")
    @Expose
    private Integer positiveReactionsCount;
    @SerializedName("published_timestamp")
    @Expose
    private String publishedTimestamp;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("flare_tag")
    @Expose
    private FlareTag flareTag;
    @SerializedName("organization")
    @Expose
    private Organization organization;

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getPositiveReactionsCount() {
        return positiveReactionsCount;
    }

    public void setPositiveReactionsCount(Integer positiveReactionsCount) {
        this.positiveReactionsCount = positiveReactionsCount;
    }

    public String getPublishedTimestamp() {
        return publishedTimestamp;
    }

    public void setPublishedTimestamp(String publishedTimestamp) {
        this.publishedTimestamp = publishedTimestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FlareTag getFlareTag() {
        return flareTag;
    }

    public void setFlareTag(FlareTag flareTag) {
        this.flareTag = flareTag;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

}