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
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_main);
        SQLiteDatabase myDB = new DatabaseHelper(this).getWritableDatabase();


//Testing ListView
        final ListView recipeListView = (ListView) findViewById(R.id.dailyRecipeListView);
        String[] recipes = new String[]{
                "Item 1",
                "Item 2",
        };

        final List<String> recipe_list = new ArrayList<String>(Arrays.asList(recipes));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipe_list);
        recipeListView.setAdapter(arrayAdapter);
//Testing ListView

        //Add OnClickListener to daily recipe floating action button
        addToDayButton = findViewById(R.id.addToDayButton);
        addToDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTodayOverlay();
            }
        });

        addToDayButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                openAddToDayActivity();
                return true;
            }
        });

    }

    public void openTodayOverlay(){
        Intent intent = new Intent(this, addTodayOverlayActivity.class);
        startActivity(intent);
    }

    //Method to open list activity
    public void openAddToDayActivity(){

        Intent intent = new Intent(this, addAllOverlayActivity.class);
        startActivity(intent);
    }
}