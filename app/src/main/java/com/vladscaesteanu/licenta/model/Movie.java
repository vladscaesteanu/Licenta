package com.vladscaesteanu.licenta.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Movie {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("duration")
    private int duration;
    @SerializedName("genre")
    private String genre;
    @SerializedName("director")
    private String director;
    @SerializedName("actorList")
    private ArrayList<String> actorList;
    @SerializedName("airDate")
    private String airDate;
    @SerializedName("description")
    private String description;
    @SerializedName("rating")
    private double rating;
    @SerializedName("seen")
    private boolean seen;
    @SerializedName("comments")
    private ArrayList<String> comments;

    public int getId() {
        return id;
    }

    public Movie(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getActorList() {
        return actorList;
    }

    public void setActorList(ArrayList<String> actorList) {
        this.actorList = actorList;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
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

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }
}
