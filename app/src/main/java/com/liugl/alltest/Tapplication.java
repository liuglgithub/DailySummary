package com.liugl.alltest;

import android.app.Application;
import android.content.Context;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Created by liugl on 2017/3/31.
 */

public class Tapplication extends Application {
    private static Tapplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //  测试的时候捕获bug
        CustomActivityOnCrash.install(this);
    }

    /**
     * 获取上下文
     */
    public static Context getApplication() {
        return application;
    }
}
