package com.example.ex_wanzhipeng001.demo_java.libs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.example.ex_wanzhipeng001.demo_java.libs.anti_hijack.AntiHijackActivity;
import com.example.ex_wanzhipeng001.demo_java.libs.constraintlayout.ConstraintLayoutActivity;
import com.example.ex_wanzhipeng001.demo_java.libs.eventbus.EventBusSubscriberActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LibsMainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LibsMainActivity";
    @BindView(R.id.btn_testHijack)
    Button btn_testHijack;
    @BindView(R.id.btn_go2Publisher)
    Button btn_testEventBus;
    @BindView(R.id.btn_constraintLayout)
    Button btn_constraintLayout;
//    @BindString(R.string.app_name) String title; //bind string or drawable...etc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libs_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_testHijack,R.id.btn_go2Publisher,R.id.btn_constraintLayout})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_testHijack:
                Intent btn_testHijack = new Intent(LibsMainActivity.this, AntiHijackActivity.class);
                startActivity(btn_testHijack);
                break;
            case R.id.btn_go2Publisher:
                Intent btn_testEventBus = new Intent(LibsMainActivity.this, EventBusSubscriberActivity.class);
                startActivity(btn_testEventBus);
                break;
            case R.id.btn_constraintLayout:
                Intent btn_constraintLayout = new Intent(LibsMainActivity.this, ConstraintLayoutActivity.class);
                startActivity(btn_constraintLayout);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
