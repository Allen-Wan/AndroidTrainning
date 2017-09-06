package com.example.ex_wanzhipeng001.demo_java.patterns_mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.login.view.MVPLoginMainActivity;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather.view.MVPWeatherMainActivity;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.weather.weather2.view.MVPWeather2MainActivity;

public class PatternMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_main3);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatternMainActivity.this, MVPLoginMainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_weather).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatternMainActivity.this, MVPWeatherMainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_weather2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatternMainActivity.this, MVPWeather2MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
