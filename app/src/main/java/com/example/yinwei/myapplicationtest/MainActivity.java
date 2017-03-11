package com.example.yinwei.myapplicationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView myTextView;

        final int i = 0;
        myTextView = (TextView)findViewById(R.id.textView1);
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "welcome to android world!";
                if(i%2 == 1){
                    str = "myandroid";
                    i++;
                }
                Toast.makeText(MainActivity.this,"someQuestion",Toast.LENGTH_LONG).show();
                myTextView.setText(str);

            }
        });
    }
}
