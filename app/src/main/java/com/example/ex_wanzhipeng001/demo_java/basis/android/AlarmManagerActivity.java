package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ex_wanzhipeng001.demo_java.R;

public class AlarmManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        Log.d("AlarmManagerActivity", "SystemClock.elapsedRealtime():" + SystemClock.elapsedRealtime());
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        PendingIntent pendingIntent;
//        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime()+10*1000,pendingIntent);
    }
}
