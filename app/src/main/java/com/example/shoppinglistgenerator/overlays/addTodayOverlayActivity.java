package com.example.shoppinglistgenerator.overlays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.shoppinglistgenerator.MainActivity;
import com.example.shoppinglistgenerator.R;
import com.example.shoppinglistgenerator.foodSearchActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addTodayOverlayActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    ImageView addFoodTV;
    ImageView addRecipeTV;
    ImageView addListTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_add_today_overlay);

        floatingActionButton = findViewById(R.id.addToDayReturnMainFAB);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnMain();
            }
        });

        addFoodTV = findViewById(R.id.addFoodToDayIV);
        addFoodTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddFood();
            }
        });



    }

    public void openAddFood(){
        Intent intent = new Intent(this, foodSearchActivity.class);
        startActivity(intent);
    }

    public void returnMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}