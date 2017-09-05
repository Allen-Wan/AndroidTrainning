package com.example.ex_wanzhipeng001.demo_java.libs.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.ex_wanzhipeng001.demo_java.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusSubscriberActivity extends AppCompatActivity {

    private  final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_subscriber);
        findViewById(R.id.btn_go2Publisher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(EventBusSubscriberActivity.this,EventBusPublisherActivity.class);
                startActivity(in);
            }
        });

        findViewById(R.id.btn_go2PublisherSticky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(EventBusSubscriberActivity.this,EventBusStickyModeActivity.class);
                startActivity(in);
            }
        });

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onCustomEventPOSTING(MessageEvent messageEvent) {
        Log.e(TAG, Thread.currentThread().getName()+"=onCustomEventPOSTING="+messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onGetDataEvent(MessageEvent messageEvent) {
        //从服务器上获取数据
        Log.e(TAG, Thread.currentThread().getName()+"=onGetDataEventBACKGROUND="+messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowDataEventMAIN(MessageEvent messageEvent) {
        //将获取的数据展示在界面上
        Log.e(TAG, Thread.currentThread().getName()+"=onShowDataEventMAIN="+messageEvent.getMessage());
    }

   @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onShowDataEventASYNC(MessageEvent messageEvent) {
        //将获取的数据展示在界面上
       Log.e(TAG, Thread.currentThread().getName()+"=onShowDataEventASYNC="+messageEvent.getMessage());
    }

}
