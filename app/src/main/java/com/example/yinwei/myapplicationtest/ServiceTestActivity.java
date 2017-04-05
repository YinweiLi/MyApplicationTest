package com.example.yinwei.myapplicationtest;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ServiceTestActivity extends AppCompatActivity {

    Button startService;
    Button stopService;
    Button bindService;
    Button unbindService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);

        startService = (Button)findViewById(R.id.button10);
        stopService  = (Button)findViewById(R.id.button11);
        bindService = (Button)findViewById(R.id.button12);
        unbindService = (Button)findViewById(R.id.button13);

        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent4StartService = new Intent();
                intent4StartService.setAction("com.example.yinwei.myapplicationtest.MyService");
                startService(intent4StartService);

            }
        });
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(ServiceTestActivity.this,MainActivity.class);
//                startActivity(i);
                Intent intent4StopService = new Intent();
                intent4StopService.setAction("com.example.yinwei.myapplicationtest.MyService");
                stopService(intent4StopService);
            }
        });

        bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4BindService = new Intent();
                intent4BindService.setAction("com.example.yinwei.myapplicationtest.MyService");
                bindService(intent4BindService,serviceConnection, Service.BIND_AUTO_CREATE);
            }
        });
        unbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4UnBindService = new Intent();
                intent4UnBindService.setAction("com.example.yinwei.myapplicationtest.MyService");
                unbindService(serviceConnection);
            }
        });
    }



    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(ServiceTestActivity.this, "Connection established...", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(ServiceTestActivity.this, "Bingding Service...", Toast.LENGTH_SHORT).show();

        }
    };
}
