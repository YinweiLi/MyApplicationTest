package com.example.yinwei.myapplicationtest;

import android.graphics.ColorMatrixColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class ImageButtonActivity extends AppCompatActivity {
    ImageButton ImageButton4Test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button);

        ImageButton4Test = (ImageButton)findViewById(R.id.imageButton2);
        //when click down
        final float[] CLICKED = new float[]{
                2,0,0,0,2,
                0,2,0,0,2,
                0,0,2,0,2,
                0,0,0,1,0};
        //when click up
        final float[] CLICKED_OVER = new float[]{
          1,0,0,0,0,
          0,1,0,0,0,
          0,0,1,0,0,
          0,0,0,1,0
        };

        ImageButton4Test.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    v.setBackgroundResource(R.drawable.yunlong);
                    v.getBackground().setColorFilter(new ColorMatrixColorFilter(CLICKED));
                    v.setBackgroundDrawable(v.getBackground());
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    v.setBackgroundResource(R.drawable.yunlong);
                    v.getBackground().setColorFilter(new ColorMatrixColorFilter(CLICKED_OVER));
                    v.setBackgroundDrawable(v.getBackground());
                }
                return false;
            }
        });
    }
}
