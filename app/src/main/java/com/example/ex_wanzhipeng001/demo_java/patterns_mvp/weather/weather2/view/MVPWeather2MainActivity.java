package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.contract.WeatherContract;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model.bean.Weather;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.model.bean.WeatherInfo;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.presenter.WeatherPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVPWeather2MainActivity extends AppCompatActivity implements WeatherContract.IWeatherView {

    @BindView(R.id.et_city_no)
    EditText mEtCityNo;
    @BindView(R.id.btn_go)
    Button mBtnGo;
    @BindView(R.id.tv_city)
    TextView mTvCity;
    @BindView(R.id.tv_city_no)
    TextView mTvCityNo;
    @BindView(R.id.tv_temp)
    TextView mTvTemp;
    @BindView(R.id.tv_WD)
    TextView mTvWD;
    @BindView(R.id.tv_WS)
    TextView mTvWS;
    @BindView(R.id.tv_SD)
    TextView mTvSD;
    @BindView(R.id.tv_WSE)
    TextView mTvWSE;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_njd)
    TextView mTvNjd;
    @BindView(R.id.activity_mvpweather_main)
    LinearLayout mActivityMvpweatherMain;

    WeatherPresenterImpl weatherPresenter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpweather_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        mBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherPresenter.getWeather(mEtCityNo.getText().toString().trim());
            }
        });
        weatherPresenter = new WeatherPresenterImpl(this);//传入WeatherView
        dialog  = new ProgressDialog(this);
        dialog.setTitle("正在查询天气");
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.dismiss();
    }

    @Override
    public void showError() {
//        WeatherPresenterImpl的onError中已经处理失败回调,不要再次处理
//        dialog.dismiss();

        Toast.makeText(this, "查询天气失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWeatherInfo(Weather weather) {
//        WeatherPresenterImpl的onSuccess中已经处理成功回调,不要再次处理
//        dialog.dismiss();

        WeatherInfo info = weather.getWeatherinfo();
        mTvCity.setText(info.getCity());
        mTvCityNo.setText(info.getCityid());
        mTvTemp.setText(info.getTemp());
        mTvWD.setText(info.getWD());
        mTvWS.setText(info.getWS());
        mTvSD.setText(info.getSD());
        mTvWSE.setText(info.getWS());
        mTvTime.setText(info.getTemp());
        mTvNjd.setText(info.getNjd());
    }
}
