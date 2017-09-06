package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.contract;

import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model.bean.Weather;

/**
 * Created by ex-wanzhipeng001 on 17/9/5.
 */

public interface WeatherContract {

    //mvp中的presenter层的回调函数
    interface WeatherPresenter {
        /**
         * 获取天气的逻辑
         */
        void getWeather(String cityNO);
    }

    //mvp中的view层回调函数
    interface IWeatherView {
        void showLoading();
        void hideLoading();
        void showError();
        void setWeatherInfo(Weather weather);
    }
}
