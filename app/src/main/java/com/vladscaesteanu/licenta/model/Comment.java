package com.vladscaesteanu.licenta.model;

import com.google.gson.annotations.SerializedName;


public class Comment {

    @SerializedName(value = "id")
    private String id;
    @SerializedName(value = "content")
    private String content;
    @SerializedName(value = "user")
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                '}';
    }
}
