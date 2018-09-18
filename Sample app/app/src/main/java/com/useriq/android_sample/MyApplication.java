package com.useriq.android_sample;

import android.app.Application;

import com.useriq.sdk.UserIQSDK;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        UserIQSDK.init(this, "9ed2bc23e5c1cb4e852b82cba195a83cede6b5a9");
        UserIQSDK.setHost("dev-mobile.useriq.com/sdk");
    }
}
