package com.xcz.baselib.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * desc  : 生命周期管理类
 * Created by xcz
 * on 2018/5/16.
 */
public class BaseLifecycleCallback implements Application.ActivityLifecycleCallbacks {


    public static BaseLifecycleCallback getInstance() {
        return HolderClass.INSTANCE;
    }


    private final static class HolderClass {
        private final static BaseLifecycleCallback INSTANCE = new BaseLifecycleCallback();
    }


    private BaseLifecycleCallback() {
    }

    /**
     * 必须在 Application 的 onCreate 方法中调用
     */
    public void init(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        AppManager.getAppManager().addActivity(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        //将当前Activity移除到容器
        AppManager.getAppManager().removeActivity(activity);
    }

}
