package com.vladscaesteanu.licenta.general_control;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;


public class ConnectionManager implements IConnectionManager {

    private static final String BASE_URL = "http://192.168.1.184";
    private static final String LOGIN_URL = "http://192.168.1.184/login";
    private static final String VIDEO_URL = "http://192.168.1.184/video";
    private Context context;
    private OkHttpClient client;
    private Gson gson;

    public ConnectionManager(Context context) {
        this.context = context;
        this.client = new OkHttpClient();
        this.gson = new Gson();
        GsonBuilder gb = new GsonBuilder();
    }

    @Override
    public void login() {

    }

    @Override
    public void getVideoContent() {

    }
}
