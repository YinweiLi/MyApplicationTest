package com.example.yinwei.myapplicationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;


public class HttpTestActivity extends AppCompatActivity {


    TextView httpTest_TV;
    Button httpTest_BUT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_test);
        httpTest_TV = (TextView)findViewById(R.id.httpTest);
        httpTest_BUT = (Button)findViewById(R.id.button18);


        httpTest_BUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uriA= "http://192.168.1.106/test.php";
                HttpURLConnection connection = null;

                try {

                    URL url = new URL(uriA);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
//                    connection.setRequestProperty("Charset","UTF-8");
//                    connection.setRequestProperty("1","this is me");
//                    connection.setDoOutput(true);
//                    connection.setDoInput(true);

//                    connection.connect();
                    httpTest_TV.setText("all over");
                }catch (Exception e){
                    httpTest_TV.setText("Problem"+e.toString());

                }




            }
        });

    }
}
