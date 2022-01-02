package com.example.shoppinglistgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class addRecipeActivitiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_add_recipe_activitiy);
    }
}