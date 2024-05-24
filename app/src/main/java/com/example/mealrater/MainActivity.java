package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {


    EditText restaurant,dish;
    MaterialButton button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restaurant=findViewById(R.id.restaurant);
        dish=findViewById(R.id.dish);
        button=findViewById(R.id.rating);
        textView=findViewById(R.id.label);


         //retrieve

        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String savedhead = preferences.getString("res", "");
        String savedlow = preferences.getString("item", "");
        restaurant.setText(savedhead);
        dish.setText(savedlow);






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res=restaurant.getText().toString();
                String item=dish.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("res",res);
                editor.putString("item",item);
                editor.apply();
                Intent intent=new Intent(MainActivity.this,ratings.class);

                startActivity(intent);
            }
        });

      Intent intent=getIntent();
      if(intent.hasExtra("rating")){
          //to check value passed by another intent if it is there or not

          float rating=intent.getFloatExtra("rating",0.0f);

          textView.setText("you rated  "+rating);

      }
    }


}