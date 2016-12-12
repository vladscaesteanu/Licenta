package com.vladscaesteanu.licenta.general_control;

import android.content.Context;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;


public class ConnectionManager implements IConnectionManager {

    private static final String BASE_URL = "http://127.0.0.1";
    private static final String LOGIN_URL = "http://127.0.0.1/login";
    private Context context;
    OkHttpClient client;
    Gson gson;

    public ConnectionManager(Context context) {
        this.context = context;
    }

    @Override
    public void login() {

    }

    @Override
    public void getReservations() {

    }

    @Override
    public void sendReservation() {

    }
}
