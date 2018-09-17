package com.useriq.android_sample;

import android.app.Application;

import com.useriq.sdk.UserIQSDK;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        UserIQSDK.init(this, "API_KEY");
    }
}
