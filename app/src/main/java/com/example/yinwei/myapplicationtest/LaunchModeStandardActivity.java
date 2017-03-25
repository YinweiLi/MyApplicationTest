package com.example.yinwei.myapplicationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LaunchModeStandardActivity extends AppCompatActivity {
    Button Standard_BT;
    TextView ShowDetial4S_TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode_standard);

        ShowDetial4S_TV = (TextView)findViewById(R.id.ShowDetial_textView3);
        Standard_BT = (Button)findViewById(R.id.button8);

        ShowDetial4S_TV.setText(this+"\n");

        Standard_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent();
                myIntent.setClass(LaunchModeStandardActivity.this,LaunchModeStandardActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
