package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.ex_wanzhipeng001.demo_java.R;

public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyService", "onBind");
        return  mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "oncreate");
        Intent intent = new Intent(this,ServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this).setContentText("text").setContentTitle
                ("title").setWhen(System.currentTimeMillis()).setSmallIcon(R.mipmap.ic_launcher).setLargeIcon
                (BitmapFactory.decodeResource(getResources(),R
                        .drawable.person))
                .setContentIntent(pendingIntent).build();
        startForeground(1,notification);//foreground service
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("MyService", "onstart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("MyService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("MyService", "onDestroy");
        super.onDestroy();
    }

    class DownloadBinder extends Binder {
        public void startDownload(){
            Log.d("DownloadBinder", "start");
        }

        public int getProgress(){
            Log.d("DownloadBinder", "getProgress");
            return 0;
        }

    }
}
