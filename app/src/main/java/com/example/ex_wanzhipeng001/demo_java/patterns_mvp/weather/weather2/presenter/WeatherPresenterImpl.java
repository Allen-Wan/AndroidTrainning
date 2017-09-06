package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.presenter;

import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.contract.WeatherContract;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model.IWeatherModel;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model.bean.Weather;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model.impl.WeatherModelImpl;

/**
 * Created by ex-wanzhipeng001 on 17/9/5.
 */

public class WeatherPresenterImpl implements WeatherContract.WeatherPresenter,OnWeatherListener {

    /*Presenter作为中间层，持有View和Model的引用*/
    IWeatherModel mIWeatherModel;
    WeatherContract.IWeatherView mIWeatherView;

    public WeatherPresenterImpl(WeatherContract.IWeatherView IWeatherView) {
        this.mIWeatherView = IWeatherView;
        mIWeatherModel = new WeatherModelImpl();
    }

    @Override
    public void getWeather(String cityNO) {
        mIWeatherView.showLoading();
        mIWeatherModel.loadWeather(cityNO,this);
    }

    @Override
    public void onError() {
        mIWeatherView.hideLoading();
        mIWeatherView.showError();
    }

    @Override
    public void onSuccess(Weather weather) {
        mIWeatherView.hideLoading();
        mIWeatherView.setWeatherInfo(weather);
    }
}
