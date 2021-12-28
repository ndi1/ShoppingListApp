package com.example.shoppinglistgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private Button recipeButton;
    private Button foodButton;
    private Button listButton;
    private FloatingActionButton addToDayButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase myDB = new DatabaseHelper(this).getWritableDatabase();



//Testing ListView
        final ListView recipeListView = (ListView) findViewById(R.id.dailyRecipeListView);
        String[] recipes = new String[]{
                "Item 1",
                "Item 2",
        };

        final List<String> recipe_list = new ArrayList<String>(Arrays.asList(recipes));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,recipe_list);
        recipeListView.setAdapter(arrayAdapter);
//Testing ListView

        //Add OnClickListener to daily recipe floating action button
        addToDayButton = findViewById(R.id.addToDayButton);
        addToDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openAddToDayActivity();
            }
        });


        //Add OnClickListener to add recipe button
        recipeButton = findViewById(R.id.addRecipeButton);
        recipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeActivity();
            }
        });

        //Add OnClickListener to add food button
        foodButton = findViewById(R.id.addFoodItemButton);
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodActivity();
            }
        });

        //Add OnClickListener to create list button
        listButton = findViewById(R.id.adToListButton);
        listButton.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, createListActivity.class);
        startActivity(intent);
    }

    //Method to open list activity
    public void openAddToDayActivity(){
        Intent intent = new Intent(this, addToDayActivity.class);
        startActivity(intent);
    }
}