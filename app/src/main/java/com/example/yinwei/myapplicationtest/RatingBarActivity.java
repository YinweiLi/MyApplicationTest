package com.example.yinwei.myapplicationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingBarActivity extends AppCompatActivity {

    TextView RatingBar_TV;
    RatingBar RatingBarDefault;
    RatingBar RatingBarSmall;
    RatingBar RatingbarIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        RatingBar_TV = (TextView)findViewById(R.id.textView4RatingBar);
        RatingBarDefault = (RatingBar)findViewById(R.id.ratingBarDefault);
        RatingBarSmall = (RatingBar)findViewById(R.id.ratingBarSmall);
        RatingbarIndicator = (RatingBar)findViewById(R.id.ratingBarIndicator);


        RatingBarDefault.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int num = ratingBar.getNumStars();
                float currating = rating;
                RatingBar_TV.setText(num+"stars"+"has been choosed"+currating);
            }
        });

        RatingBarSmall.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int num = ratingBar.getNumStars();
                float currating = rating;
                RatingBar_TV.setText(num+"stars"+"has been choosed"+currating);
            }
        });

        RatingbarIndicator.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int num = ratingBar.getNumStars();
                float currating = rating;
                RatingBar_TV.setText(num+"stars"+"has been choosed"+currating);
            }
        });
    }
}
