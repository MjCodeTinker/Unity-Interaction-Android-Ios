package com.mj.android_plugin_unity.base;

import android.app.Activity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * unity 工具类
 */
public class UnityUtils {

    /**
     * unity项目启动时的的上下文
     */
    private static Activity unityActivity;

    /**
     * 获取unity项目的上下文
     *
     * @return unity中对应的Activity
     */
    public static Activity getUnityActivity() {
        if (null == unityActivity) {
            try {
                Class<?> classType = Class.forName("com.unity3d.player.UnityPlayer");
                unityActivity = (Activity) classType.getDeclaredField("currentActivity").get(classType);
            } catch (ClassNotFoundException e) {
                // TODO: 2019/5/16  异常处理
            } catch (IllegalAccessException e) {
                // TODO: 2019/5/16  异常处理
            } catch (NoSuchFieldException e) {
                // TODO: 2019/5/16 异常处理
            }
        }
        return unityActivity;
    }

    /**
     * Android中调用Unity的方法
     *
     * @param gameObjectName 调用的GameObject的名称
     * @param functionName   方法名
     * @param args           参数
     * @return 调用是否成功
     */
    public static boolean invokeUnity(String gameObjectName, String functionName, String args) {
        try {
            Class<?> classType = Class.forName("com.unity3d.player.UnityPlayer");
            Method method = classType.getMethod("UnitySendMessage", String.class, String.class, String.class);
            method.invoke(classType, gameObjectName, functionName, args);
            return true;
        } catch (ClassNotFoundException e) {
            // TODO: 2019/5/16 异常处理
        } catch (NoSuchMethodException e) {
            // TODO: 2019/5/16 异常处理
        } catch (IllegalAccessException e) {
            // TODO: 2019/5/16 异常处理
        } catch (InvocationTargetException e) {
            // TODO: 2019/5/16 异常处理
        }
        return false;
    }
}
