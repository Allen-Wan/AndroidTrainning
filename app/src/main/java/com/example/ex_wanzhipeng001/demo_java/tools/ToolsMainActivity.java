package com.example.ex_wanzhipeng001.demo_java.tools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.example.ex_wanzhipeng001.demo_java.tools.anti_hijack.AntiHijackActivity;
import com.example.ex_wanzhipeng001.demo_java.tools.eventbus.EventBusSubscriberActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToolsMainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ToolsMainActivity";
    @BindView(R.id.btn_testHijack)
    Button btn_testHijack;
    @BindView(R.id.btn_go2Publisher)
    Button btn_testEventBus;
//    @BindString(R.string.app_name) String title; //bind string or drawable...etc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_testHijack,R.id.btn_go2Publisher})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_testHijack:
                Intent btn_testHijack = new Intent(ToolsMainActivity.this, AntiHijackActivity.class);
                startActivity(btn_testHijack);
                break;
            case R.id.btn_go2Publisher:
                Intent btn_testEventBus = new Intent(ToolsMainActivity.this, EventBusSubscriberActivity.class);
                startActivity(btn_testEventBus);
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
