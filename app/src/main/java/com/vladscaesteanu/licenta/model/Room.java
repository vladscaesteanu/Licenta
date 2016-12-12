package com.vladscaesteanu.licenta.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Room {

    @SerializedName("id")
    private int id;
    @SerializedName("seats")
    private List<Seat> seats;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", seats=" + seats +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
