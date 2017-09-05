package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.presenter;


import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.model.bean.Weather;

/**
 * Created by ex-wanzhipeng001 on 17/9/5.
 */
public interface OnWeatherListener {
    void onError();
    void onSuccess(Weather weather);
}
