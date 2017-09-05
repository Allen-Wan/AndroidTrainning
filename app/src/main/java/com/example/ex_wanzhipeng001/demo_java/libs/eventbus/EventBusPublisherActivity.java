package com.example.ex_wanzhipeng001.demo_java.libs.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.ex_wanzhipeng001.demo_java.R;

import org.greenrobot.eventbus.EventBus;

public class EventBusPublisherActivity extends AppCompatActivity {

    private  final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_publisher);

        findViewById(R.id.btn_publish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "btn_publish="+Thread.currentThread().getName());
                EventBus.getDefault().post(new MessageEvent("btn_publish clicked"));
            }
        });

        findViewById(R.id.btn_publishInThread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e(TAG, "btn_publishInThread="+Thread.currentThread().getName());
                        EventBus.getDefault().post(new MessageEvent("btn_publishInThread clicked"));
                    }
                }).start();
            }
        });

    }
}
