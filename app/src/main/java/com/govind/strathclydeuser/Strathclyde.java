package com.govind.strathclydeuser;

import android.app.Application;

import com.onesignal.OneSignal;

public class Strathclyde extends Application {
    private static final String ONESIGNAL_APP_ID = "527f0471-64ea-4282-a504-61fd8bb5939c";
    @Override
    public void onCreate() {
        super.onCreate();
        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}