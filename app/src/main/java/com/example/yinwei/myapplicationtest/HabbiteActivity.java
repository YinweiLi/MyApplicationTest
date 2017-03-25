package com.example.yinwei.myapplicationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class HabbiteActivity extends AppCompatActivity {
    TextView habit;
    CheckBox Sports_CheckBox;
    CheckBox Learning_CheckBox;
    CheckBox Hiking_CheckBox;
    CheckBox Ball_CheckBox;
    String allHabit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habbite);

        habit = (TextView)findViewById(R.id.shouDetaile_TextView);
        Sports_CheckBox = (CheckBox)findViewById(R.id.Sports_checkBox);
        Learning_CheckBox = (CheckBox)findViewById(R.id.Learn_checkBox);
        Hiking_CheckBox = (CheckBox)findViewById(R.id.Hike_checkBox);
        Ball_CheckBox = (CheckBox)findViewById(R.id.Ball_checkBox);
        allHabit = "Habbite:\n";

        habit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = "asdfghjkl;asdfghjkl";
                //test.replaceAll("qw","");
                habit.setText(test.replaceAll("qw",""));
            }
        });
        Sports_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                allHabit = SetAllHabit(allHabit,buttonView,isChecked);
                habit.setText(allHabit);
            }
        });
        Learning_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                allHabit = SetAllHabit(allHabit,buttonView,isChecked);
                habit.setText(allHabit);
            }
        });
        Hiking_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                allHabit = SetAllHabit(allHabit,buttonView,isChecked);
                habit.setText(allHabit);
            }
        });
        Ball_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                allHabit = SetAllHabit(allHabit,buttonView,isChecked);
                habit.setText(allHabit);
            }
        });

    }
    //返回字符串的时候出现问题
    //每次选择(取消选择)菜单都会只出现(消除)当前的选中项
    //别的选中项都被抹掉了
    //变量尽量避免重名，尽管不再同一作用域内，不然会很乱的
    public String SetAllHabit(String a,CompoundButton buttonView, boolean isChecked){
        String result = a;
        if(isChecked){
            result = result + buttonView.getText();
            result = result + "\n";
            //a += "\n";
        }else if(!isChecked){
            String f = (String) buttonView.getText();
            f += "\n";
            result = result.replaceAll(f ,"");
        }
        return result;
    }
}
