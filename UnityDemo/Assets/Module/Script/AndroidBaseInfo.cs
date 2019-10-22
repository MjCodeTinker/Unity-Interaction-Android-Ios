using System;
using UnityEngine;

public class AndroidBaseInfo : AndroidJavaProxy
{
    // 成功的回调
    private Action<string> _successAction;

    // 失败的回调
    private Action<int, string> _errorAction;

    // 构造方法
    public AndroidBaseInfo(Action<string> successAction, Action<int,string> errorAction) : base(
        "com.mj.android_plugin_unity.in.IAndroidBaseInfoCallback")
    {
        _successAction = successAction;
        _errorAction = errorAction;
    }

    /**
     * 成功
     */
    public void onSuccess(string jsonResult)
    {
        Debug.Log("unity 收到消息：onSuccess =" + jsonResult);
        _successAction?.Invoke(jsonResult);
    }

    /**
     * 错误
     */
    public void onError(int errorCode, string errorMessage)
    {
        Debug.Log("unity 收到消息：onError =" + errorCode + "--errorMessage=" + errorMessage);
        _errorAction?.Invoke(errorCode, errorMessage);
    }
}