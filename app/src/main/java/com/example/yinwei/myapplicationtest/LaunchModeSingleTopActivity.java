package com.example.yinwei.myapplicationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LaunchModeSingleTopActivity extends AppCompatActivity {
    Button SingleTop_BT;
    TextView ShowDetial4T_TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode_single_top);

        ShowDetial4T_TV = (TextView)findViewById(R.id.ShowDetial_textView);
        SingleTop_BT = (Button)findViewById(R.id.button9);

        ShowDetial4T_TV.setText(this+"\n");

        SingleTop_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent();
                myIntent.setClass(LaunchModeSingleTopActivity.this,LaunchModeSingleTopActivity.class);
                startActivity(myIntent);

            }
        });
    }
}
