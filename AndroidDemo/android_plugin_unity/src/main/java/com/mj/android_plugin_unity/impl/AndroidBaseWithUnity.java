package com.mj.android_plugin_unity.impl;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.provider.Settings;
import android.util.Log;

import com.mj.android_plugin_unity.base.UnityUtils;
import com.mj.android_plugin_unity.in.IAndroidBaseInfoCallback;

import org.json.JSONObject;


/**
 * 为unity提供的android基类
 */
public class AndroidBaseWithUnity {


    private static final String TAG = "AndroidBaseWithUnity";

    // 获取android信息
    public void getAndroidBaseInfo(IAndroidBaseInfoCallback callback) {

        if (callback == null) {
            Log.i(TAG, "callback is null");
            return;
        }
        String androidId = null;
        try {
            androidId = getAndroidId(UnityUtils.getUnityActivity().getContentResolver());
            JSONObject jsonObject = new JSONObject();
            jsonObject.putOpt("androidId", androidId);
            callback.onSuccess(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            callback.onError(1, "get android id exception = " + e.getMessage());
        }

    }

    /**
     * 获取androidId
     *
     * @param contentResolver contentResolver
     * @return android id
     */
    @SuppressLint("HardwareIds")
    private String getAndroidId(ContentResolver contentResolver) {
        return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID);
    }


}
