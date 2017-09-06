package com.example.ex_wanzhipeng001.demo_java.app;

import android.app.Application;

import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.util.volley.VolleyRequest;


/**
 * Created by ex-wanzhipeng001 on 17/9/5.
 */


/**
 * Created by Administrator on 2015/2/6.
 * 替换默认的Application实现
 */
public class DemoApplication extends Application {
    private static DemoApplication instance;

    public DemoApplication() {
        instance = this;
    }

    public static Application getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyRequest.buildRequestQueue(this);
    }
}
