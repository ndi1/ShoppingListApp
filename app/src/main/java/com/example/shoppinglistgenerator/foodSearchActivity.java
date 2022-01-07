package com.example.shoppinglistgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class foodSearchActivity extends AppCompatActivity {

    FloatingActionButton addFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_search);

        addFood = findViewById(R.id.addFoodFABSearch);
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddFoodFromSearch();
            }
        });

    }

    public void openAddFoodFromSearch(){
        Intent intent = new Intent(this, addFoodActivity.class);
        startActivity(intent);

    }
}