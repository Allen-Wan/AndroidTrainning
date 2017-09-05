package com.example.ex_wanzhipeng001.demo_java.libs.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.ex_wanzhipeng001.demo_java.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusStickyModeActivity extends AppCompatActivity {
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_mode);
        findViewById(R.id.post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new MessageEvent("test" + index++));
            }
        });
        findViewById(R.id.regist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().register(EventBusStickyModeActivity.this);
            }
        });

        findViewById(R.id.unregist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().unregister(EventBusStickyModeActivity.this);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMessageEventPostThread(MessageEvent messageEvent) {
        Log.e("PostThread", messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMessageEventMainThread(MessageEvent messageEvent) {
        Log.e("MainThread", messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND, sticky = true)
    public void onMessageEventBackgroundThread(MessageEvent messageEvent) {
        Log.e("BackgroundThread", messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.ASYNC, sticky = true)
    public void onMessageEventAsync(MessageEvent messageEvent) {
        Log.e("Async", messageEvent.getMessage());
    }
}
