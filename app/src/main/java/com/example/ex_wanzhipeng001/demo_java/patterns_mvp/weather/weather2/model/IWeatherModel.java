package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model;

import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.presenter.OnWeatherListener;

/**
 * Created by ex-wanzhipeng001 on 17/9/5.
 */

public interface IWeatherModel {
    void loadWeather(String cityNo, OnWeatherListener listener);
}
