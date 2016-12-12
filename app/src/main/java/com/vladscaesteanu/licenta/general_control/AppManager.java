package com.vladscaesteanu.licenta.general_control;


import android.content.Context;

public class AppManager implements IAppManager {

    private Context context;
    private ConnectionManager connectionManager;

    public AppManager(Context context) {
        this.context = context;
        this.connectionManager = new ConnectionManager(context);
      /*  this.mapManager = new MapManager(context);
        this.imageManager = new ImageManager(context);
        this.profileManager = new ProfileManager(context);
        this.locationStorage = new LocationStorage();
        this.loginManager = new LoginManager(context);
        this.permissionManager = new PermissionManager();
        this.profileManager.setMapManager(this.mapManager);
        this.imageManager.setConnectionManager(this.connectionManager);
        readMap();
        this.loginManager.addLoginStatusChangedListener(new C10861());*/
    }
}
