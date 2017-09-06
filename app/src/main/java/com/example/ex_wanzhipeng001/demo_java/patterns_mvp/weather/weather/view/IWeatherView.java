package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather.view;

import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather.model.bean.Weather;

/**
 * Created by ex-wanzhipeng001 on 17/9/5.
 */

public interface IWeatherView {
    void showLoading();
    void hideLoading();
    void showError();
    void setWeatherInfo(Weather weather);
}
