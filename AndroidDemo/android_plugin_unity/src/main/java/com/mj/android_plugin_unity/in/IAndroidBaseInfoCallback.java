package com.mj.android_plugin_unity.in;

/**
 * android 基本信息的回调接口
 */
public interface IAndroidBaseInfoCallback {
    /**
     * 成功
     *
     * @param jsonResult json结果
     */
    public void onSuccess(String jsonResult);

    /**
     * 错误
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     */
    public void onError(int errorCode, String errorMessage);
}
