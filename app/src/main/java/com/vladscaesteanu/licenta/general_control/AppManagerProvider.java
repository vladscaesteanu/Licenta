package com.vladscaesteanu.licenta.general_control;



public class AppManagerProvider {
    private static AppManagerProvider instance;
    private IAppManager appManager;

    public static AppManagerProvider getInstance() {
        if (instance == null) {
            instance = new AppManagerProvider();
        }
        return instance;
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