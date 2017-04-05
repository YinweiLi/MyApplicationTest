package com.example.yinwei.myapplicationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class SelecteOSActivity extends AppCompatActivity {
    Button selectOS_B;
    RadioButton RB1;
    RadioButton RB2;
    RadioButton RB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecte_os);
        selectOS_B = (Button)findViewById(R.id.button7);
        RB1 = (RadioButton)findViewById(R.id.radioButton1);
        RB2 = (RadioButton)findViewById(R.id.radioButton2);
        RB3 = (RadioButton)findViewById(R.id.radioButton3);

        selectOS_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent myShowOSIntent = new Intent();
                myShowOSIntent.setClass(SelecteOSActivity.this,ShowOSActivity.class);

                Bundle myBundle = new Bundle();

                if(RB1.isChecked()){
                    myBundle.putString("SRB",(String)RB1.getText());
                }
                if (RB2.isChecked()){
                    myBundle.putString("SRB",(String)RB2.getText());
                }
                if (RB3.isChecked()){
                    myBundle.putString("SRB",(String)RB3.getText());
                }
                else {
                    myBundle.putString("selected_RadioButton","nothing!");

                }
                myShowOSIntent.putExtras(myBundle);

                SelecteOSActivity.this.startActivity(myShowOSIntent);
                //SelecteOSActivity.this.finish();
                //finish this activity
            }
        });
    }
}
