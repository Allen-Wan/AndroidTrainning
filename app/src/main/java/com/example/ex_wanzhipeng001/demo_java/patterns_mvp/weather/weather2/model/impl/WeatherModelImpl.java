package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model.IWeatherModel;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model.bean.Weather;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.presenter.OnWeatherListener;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.util.volley.VolleyRequest;

/**
 * Created by ex-wanzhipeng001 on 17/9/5.
 * 天气Model实现
 */

public class WeatherModelImpl implements IWeatherModel {

    @Override
    public void loadWeather(String cityNo, final OnWeatherListener listener) {
//        /*数据层操作*/
        VolleyRequest.newInstance().newGsonRequest("http://www.weather.com.cn/data/sk/" + cityNo + ".html",
                Weather.class, new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather weather) {
                        if (weather != null) {
                            listener.onSuccess(weather);
                        } else {
                            listener.onError();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError();
                    }
                });
    }
}
