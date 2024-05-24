package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ratings extends AppCompatActivity {

    RatingBar ratingBar;
    TextView head;
    MaterialButton save,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        ratingBar=findViewById(R.id.bar);
        head=findViewById(R.id.heading);
        save=findViewById(R.id.save);
        cancel=findViewById(R.id.cancel);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float val=ratingBar.getRating();
                Intent intent=new Intent(ratings.this,MainActivity.class);
                intent.putExtra("rating",val);
                startActivity(intent);
                finish();

            }
        });




        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                //going back to activity

            }
        });




    }
}