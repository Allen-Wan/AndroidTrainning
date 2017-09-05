package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.presenter;

/**
 * Created by ex-wanzhipeng001 on 17/9/5.
 */

public interface WeatherPresenter {
    /**
     * 获取天气的逻辑
     */
    void getWeather(String cityNO);
}
