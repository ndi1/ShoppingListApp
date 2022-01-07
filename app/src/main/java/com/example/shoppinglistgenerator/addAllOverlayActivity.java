package com.example.shoppinglistgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addAllOverlayActivity extends AppCompatActivity {

    FloatingActionButton returnMainButton;
    ImageView addFoodIV;
    ImageView addRecipeIV;
    ImageView addListIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_add_all_overlay);

        //Add OnClickListener to daily recipe floating action button
        returnMainButton = findViewById(R.id.returnMainFAB);
        returnMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnMain();
            }
        });

        //Add OnClickListener to add food button
        addFoodIV = findViewById(R.id.foodIV);
        addFoodIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodActivity();
            }
        });


        //Add OnClickListener to add recipe button
        addRecipeIV = findViewById(R.id.recipeIV);
        addRecipeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeActivity();
            }
        });

        //Add OnClickListener to list button
        addListIV = findViewById(R.id.listIV);
        addListIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListActivity();
            }
        });


    }

    //Method to open recipe activity
    public void openRecipeActivity(){
        Intent intent = new Intent(this, addRecipeActivitiy.class);
        startActivity(intent);
    }

    //Method to open food activity
    public void openFoodActivity(){
        Intent intent = new Intent(this, addFoodActivity.class);
        startActivity(intent);
    }

    //Method to open list activity
    public void openListActivity(){
        Intent intent = new Intent(this, addItemActivity.class);
        startActivity(intent);
    }

    public void returnMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}