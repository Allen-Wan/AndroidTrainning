package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.presenter;


import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model.bean.Weather;

/**
 * Created by ex-wanzhipeng001 on 17/9/5.
 */
public interface OnWeatherListener {
    void onError();
    void onSuccess(Weather weather);
}
