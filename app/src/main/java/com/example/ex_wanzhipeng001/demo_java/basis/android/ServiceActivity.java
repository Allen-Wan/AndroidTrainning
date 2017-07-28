package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ex_wanzhipeng001.demo_java.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceActivity extends AppCompatActivity {

    @BindView(R.id.btn_startService)
    Button mBtnStartService;
    @BindView(R.id.btn_stopService)
    Button mBtnStopService;
    @BindView(R.id.btn_bindService)
    Button mBtnBindService;
    @BindView(R.id.btn_unbindService)
    Button mBtnUnbindService;
    @BindView(R.id.btn_intentService)
    Button mBtnIntentService;

    private MyService.DownloadBinder mDownloadBinder;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (MyService.DownloadBinder) service;
            mDownloadBinder.startDownload();
            mDownloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_startService, R.id.btn_stopService,R.id.btn_bindService, R.id.btn_unbindService,R.id.btn_intentService})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_startService:
                Intent intent1 = new Intent(this, MyService.class);
                startService(intent1);
                break;
            case R.id.btn_stopService:
                Intent intent2 = new Intent(this, MyService.class);
                stopService(intent2);
                break;
            case R.id.btn_bindService:
                Intent intent3 = new Intent(this, MyService.class);
                bindService(intent3,mServiceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbindService:
                unbindService(mServiceConnection);
                break;
            case R.id.btn_intentService:
                Log.d("ServiceActivity", "btn_intentService:" + Thread.currentThread().getId());
                Intent intent4 = new Intent(this, MyIntentService.class);
                startService(intent4);
                break;
            default:
                break;
        }
    }



}
