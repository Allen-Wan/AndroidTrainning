package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ex_wanzhipeng001.demo_java.R;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        findViewById(R.id.btn_sendNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationActivity.this);
                Intent intent = new Intent(NotificationActivity.this,NotificationDetailsActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this,0,intent,PendingIntent.FLAG_ONE_SHOT);
                Notification notification = builder.
                        setContentTitle("content title").
                        setContentText("content text").
                        setWhen(System.currentTimeMillis()).
                        setSmallIcon(R.mipmap.ic_launcher).//只能设置alpha图层的图片 才行
                        setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.person)).
                        setContentIntent(pendingIntent).
                        setProgress(100,50,false).
//                        setAutoCancel(true).
//                        setSound()
//                        setVibrate()
//                        setLights()
//                        setStyle() //bigTextStyle bigPictureStyle
//                        setPriority()
                        setDefaults(NotificationCompat.DEFAULT_ALL).
                        build();
                manager.notify(1,notification); //set id to cancel
            }
        });
    }
}
