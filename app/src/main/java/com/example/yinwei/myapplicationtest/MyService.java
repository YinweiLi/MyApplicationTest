package com.example.yinwei.myapplicationtest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }
    //override this methods and add a toast in it
    //show the call-machinism in activity
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(MyService.this,"Bingding Service...",Toast.LENGTH_SHORT).show();
        return null;
    }
    public void onCreate(){
        Toast.makeText(MyService.this,"Creating Service...",Toast.LENGTH_SHORT).show();

    }
    public void onStart(Intent intent,int startID){
        Toast.makeText(MyService.this,"Starting Service...",Toast.LENGTH_SHORT).show();

    }
    public void onDestroy(){
        Toast.makeText(MyService.this,"Destroying Service...",Toast.LENGTH_SHORT).show();

    }
//service需要手動在manifest裏面注冊一個action->intent-filter
}
