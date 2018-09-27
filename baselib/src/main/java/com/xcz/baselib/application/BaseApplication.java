package com.xcz.baselib.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;

import com.xcz.baselib.utils.Utils;
import com.xcz.baselib.utils.log.LogUtils;


/**
 * 基类Application
 * Created by xcz
 * on 2018/5/15.
 */
public class BaseApplication extends Application {


    private static BaseApplication instance;

    public static synchronized BaseApplication getInstance() {
        if (null == instance) {
            instance = new BaseApplication();
        }
        return instance;
    }

    public BaseApplication() {
    }

    /**
     * 这个最先执行
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    /**
     * 程序启动的时候执行
     */
    @Override
    public void onCreate() {
        LogUtils.d("Application", "onCreate");
        super.onCreate();
        instance = this;
        Utils.init(this);
        BaseLifecycleCallback.getInstance().init(this);
    }


    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        LogUtils.d("Application", "onTerminate");
        super.onTerminate();
    }


    /**
     * 低内存的时候执行
     */
    @Override
    public void onLowMemory() {
        LogUtils.d("Application", "onLowMemory");
        super.onLowMemory();
    }


    /**
     * HOME键退出应用程序
     * 程序在内存清理的时候执行
     */
    @Override
    public void onTrimMemory(int level) {
        LogUtils.d("Application", "onTrimMemory");
        super.onTrimMemory(level);
    }


    /**
     * onConfigurationChanged
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        LogUtils.d("Application", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }


}
