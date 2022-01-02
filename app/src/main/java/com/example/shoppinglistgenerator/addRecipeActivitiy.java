package com.example.shoppinglistgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addRecipeActivitiy extends AppCompatActivity {

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_add_recipe_activitiy);
        floatingActionButton = findViewById(R.id.addFoodToRecipeFAB);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodSearch();
            }
        });


    }

    public void openFoodSearch(){
        Intent intent = new Intent(this,foodSearchActivity.class);
        startActivity(intent);
    }

}