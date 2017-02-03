package com.vladscaesteanu.licenta;

import android.app.Application;

import com.vladscaesteanu.licenta.general_control.AppManager;
import com.vladscaesteanu.licenta.general_control.AppManagerProvider;
import com.vladscaesteanu.licenta.general_control.IAppManager;



public class App extends Application {

    private AppManager appManager;

    public void onCreate() {
        super.onCreate();
        this.appManager = new AppManager(getApplicationContext());
        try {
            AppManagerProvider.getInstance().setAppManager(this.appManager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IAppManager getAppManager() {
        return this.appManager;
    }
}
