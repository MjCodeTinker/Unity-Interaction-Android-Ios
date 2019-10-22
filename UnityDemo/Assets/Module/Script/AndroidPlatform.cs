using System;
using UnityEngine;

public class AndroidPlatform : MonoBehaviour
{
    private readonly AndroidJavaObject _androidBaseWithUnity;

    private static AndroidPlatform _instance;

    public static AndroidPlatform Instance
    {
        get
        {
            if (_instance != null) return _instance;
            _instance = FindObjectOfType(typeof(AndroidPlatform)) as AndroidPlatform;
            if (_instance != null) return _instance;
            var obj = new GameObject(typeof(AndroidPlatform).Name);
            _instance = obj.AddComponent<AndroidPlatform>();
            return _instance;
        }
    }

    private AndroidPlatform()
    {
        _androidBaseWithUnity = new AndroidJavaObject("com.mj.android_plugin_unity.impl.AndroidBaseWithUnity");
    }

    // 获取android 信息
    public void GetAndoridInfo(Action<AndroidBaseEntity> callBack)
    {
        _androidBaseWithUnity.Call("getAndroidBaseInfo",
            new AndroidBaseInfo(delegate(string success)
                {
                    Debug.Log("success = " + success);
                    var androidBaseEntity = JsonUtility.FromJson<AndroidBaseEntity>(success);
                    callBack?.Invoke(androidBaseEntity);
                },
                delegate(int errorCode, string errorMessage)
                {
                    Debug.Log("errorCode = " + errorCode + "--errorMessage=" + errorMessage);
                }));
    }
}