package com.vladscaesteanu.licenta.general_control;



public class AppManagerProvider {
    private static AppManagerProvider _instance;
    private IAppManager appManager;

    public static AppManagerProvider getInstance() {
        if (_instance == null) {
            _instance = new AppManagerProvider();
        }
        return _instance;
    }

    private AppManagerProvider() {
    }

    public void setAppManager(IAppManager appManager) throws AppManagerException {
        if (this.appManager != null) {
            throw new AppManagerException();
        }
        this.appManager = appManager;
    }

    public IAppManager getAppManager() {
        return this.appManager;
    }
}