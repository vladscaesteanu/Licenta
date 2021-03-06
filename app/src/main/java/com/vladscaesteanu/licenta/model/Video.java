package com.vladscaesteanu.licenta.model;


import android.graphics.Bitmap;
import android.media.Image;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Video {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("duration")
    private int duration;
    @SerializedName("description")
    private String description;
    @SerializedName("rating")
    private double rating;
    @SerializedName("seen")
    private boolean seen;
    @SerializedName("comments")
    private ArrayList<Comment> comments;
    @SerializedName("path")
    private String path;
    private Bitmap image;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public Video(int id, String name, String description, String path, Bitmap image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
