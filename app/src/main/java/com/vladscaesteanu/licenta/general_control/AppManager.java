package com.vladscaesteanu.licenta.general_control;


import android.content.Context;

public class AppManager implements IAppManager {

    private Context context;
    private ConnectionManager connectionManager;

    public AppManager(Context context) {
        this.context = context;
        this.connectionManager = new ConnectionManager(context);
    }
}
