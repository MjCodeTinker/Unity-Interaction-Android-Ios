package com.mj.android_plugin_unity.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class AndroidPluginForUnityApplication extends Application {


    private static final String TAG = "ForUnityApp";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate()");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.i(TAG,"attachBaseContext()");
    }
}
