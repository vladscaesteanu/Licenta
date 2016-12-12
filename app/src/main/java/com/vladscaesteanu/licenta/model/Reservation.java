package com.vladscaesteanu.licenta.model;


import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Reservation {

    @SerializedName("id")
    private int id;
    @SerializedName("movie")
    private Movie movie;
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;
    @SerializedName("room")
    private Room room;
    @SerializedName("seats")
    private List<Seat> seats;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", movie=" + movie +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", room=" + room +
                ", seats=" + seats +
                '}';
    }
}
