package com.example.yinwei.myapplicationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WeatherNoticeActivity extends AppCompatActivity {

    Button Sunny_BT,Rain_BT,Snow_BT,Unbind_BT;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_notice);
        Sunny_BT = (Button)findViewById(R.id.button14);
        Rain_BT = (Button)findViewById(R.id.button15);
        Snow_BT = (Button)findViewById(R.id.button16);
        Unbind_BT = (Button)findViewById(R.id.button17);
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        Sunny_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherNoticeActivity.this,"Sunnny",Toast.LENGTH_SHORT).show();
                showWeather("WeatherChanged","Sunny","晴空万里",R.drawable.notification);
            }
        });
        Rain_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherNoticeActivity.this,"Raining",Toast.LENGTH_SHORT).show();
                showWeather("WeatherChanged","Raining","大雨倾盆",R.drawable.notification);

            }
        });
        Snow_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherNoticeActivity.this,"Snowing",Toast.LENGTH_SHORT).show();
                showWeather("WeatherChanged","Snowing","大学凤飞",R.drawable.notification);

            }
        });
        Unbind_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherNoticeActivity.this,"Unbind",Toast.LENGTH_SHORT).show();
                notificationManager.cancel(R.layout.activity_weather_notice);
            }
        });

    }//onCreat()
    private void showWeather(String tickerText,String title,String content,int drawable){

//        Notification notification = new Notification(drawable,tickerText,
//                System.currentTimeMillis());
//
//        PendingIntent myPendingItent4Notice = PendingIntent.getActivity(this,0,
//                new Intent(this,WeatherNoticeActivity.class),0);
//
//        notification.setLatestEventInfo(this,title,content,myPendingItent4Notice);
//        notificationManager.notify(R.layout.activity_weather_notice,notification);

        PendingIntent myPendingItent4Notice = PendingIntent.getActivity(this,0,
                new Intent(this,WeatherNoticeActivity.class),0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setAutoCancel(true);
        builder.setTicker(tickerText);
        builder.setSmallIcon(drawable);
        //builder.setLargeIcon(d);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setSound(Uri.parse("android.resource://org.crazyit.ui"+R.raw.msg));
        builder.setWhen(System.currentTimeMillis());
        builder.setContentIntent(myPendingItent4Notice);
        Notification notification = builder.getNotification();
        //notification.build();
        notificationManager.notify(R.layout.activity_weather_notice,notification);
    }
//问题多多
/*
* 構造Notification遇到了版本問題，書上低版本sdk和高版本sdk構造不一樣
* 上網查了新版的notification構造才好使
* 一個通知欄的通知有好多信息
* 這裏用一個notification的builder來構造它裏面的信息
*
*
* */




}//class
