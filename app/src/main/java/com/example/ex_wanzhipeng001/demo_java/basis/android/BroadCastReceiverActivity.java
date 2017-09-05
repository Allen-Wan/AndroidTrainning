package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ex_wanzhipeng001.demo_java.R;

public class BroadCastReceiverActivity extends AppCompatActivity {

    private NetReceiver netReceiver;
    private ScreenToggleReceiver screenToggleReceiver;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        netReceiver = new NetReceiver();
        screenToggleReceiver = new ScreenToggleReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);//can not receive when register in manifest.xml
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_MANAGE_NETWORK_USAGE);
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(netReceiver,intentFilter);
        registerReceiver(screenToggleReceiver,intentFilter);

        //本地广播
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("test local broadcast receiver");
        localReceiver = new LocalReceiver();
        manager = LocalBroadcastManager.getInstance(this);
        manager.registerReceiver(localReceiver,intentFilter2);

        findViewById(R.id.btn_sendLocalBroadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("test local broadcast receiver");
                manager.sendBroadcast(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netReceiver);
        unregisterReceiver(screenToggleReceiver);
        manager.unregisterReceiver(localReceiver);
    }

    private class NetReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    Toast.makeText(context, activeNetworkInfo.getTypeName(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "not available", Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(context, "null", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private  class ScreenToggleReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            PowerManager manager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            Log.e("==",intent.getAction()+"---manager.isScreenOn():" + manager.isScreenOn());
        }
    }
    private  class LocalReceiver extends  BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "local received", Toast.LENGTH_SHORT).show();
        }
    }

}
