package com.example.yinwei.myapplicationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowOSActivity extends AppCompatActivity {
    TextView showOSTW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_os);

        showOSTW = (TextView)findViewById(R.id.showtextView);
        Intent myIntent = this.getIntent();
        Bundle myBundle = myIntent.getExtras();
        String selectedOS = myBundle.getString("SRB");
        if(selectedOS != null){
            showOSTW.setText(selectedOS);
        }else {
            showOSTW.setText("NO");
        }



    }
}
