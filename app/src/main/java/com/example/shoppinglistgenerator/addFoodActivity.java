package com.example.shoppinglistgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addFoodActivity extends AppCompatActivity {

DatabaseHelper myDB;
private FloatingActionButton addFoodButton;
private EditText foodNameTextbox,foodDescriptionTextbox,caloriesTextbox,fatsTextbox,carbsTextbox,proteinTextbox,servingSizeTextbox;
private Spinner servingsSpinner;
private String spinnerSelection,foodText,foodDescText;
private Double calDouble, fatsDouble, carbsDouble, proteinDouble, servingsDouble;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_add_food);
        myDB = new DatabaseHelper(this);
        Spinner servingsSpinner = findViewById(R.id.servingSpinner);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.servings, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        servingsSpinner.setAdapter(adapter);

        addFoodButton = findViewById(R.id.floatingActionButton3);
        addFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFood();
            }
        });



    }

    public void addFood(){

        foodNameTextbox = findViewById(R.id.foodNameTextbox);
        foodDescriptionTextbox = findViewById(R.id.foodDescriptionTextbox);
        caloriesTextbox = findViewById(R.id.caloriesTextbox);
        fatsTextbox = findViewById(R.id.fatsTextbox);
        carbsTextbox = findViewById(R.id.carbsTextbox);
        proteinTextbox = findViewById(R.id.proteinTextbox);
        servingSizeTextbox = findViewById(R.id.servingSizeTextbox);
        servingsSpinner = findViewById(R.id.servingSpinner);



        foodText = foodNameTextbox.getText().toString();

        foodDescText = foodDescriptionTextbox.getText().toString();

        try {
            calDouble = Double.parseDouble(caloriesTextbox.getText().toString());
        } catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Calories Must Be Numbers",Toast.LENGTH_LONG).show();
        }

        try {
            fatsDouble = Double.parseDouble(fatsTextbox.getText().toString());
        } catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Fats Must Be Numbers",Toast.LENGTH_LONG).show();
        }

        try {
            carbsDouble = Double.parseDouble(carbsTextbox.getText().toString());
        } catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Calories Must Be Numbers",Toast.LENGTH_LONG).show();
        }

        try {
            proteinDouble = Double.parseDouble(proteinTextbox.getText().toString());
        } catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Calories Must Be Numbers",Toast.LENGTH_LONG).show();
        }

        try {
            servingsDouble = Double.parseDouble(servingSizeTextbox.getText().toString());
        } catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Calories Must Be Integers",Toast.LENGTH_LONG).show();
        }


        spinnerSelection = servingsSpinner.getSelectedItem().toString();

        Boolean isAdded = myDB.addFoods(foodText,foodDescText, calDouble, fatsDouble, carbsDouble, proteinDouble, servingsDouble,spinnerSelection);
        if (isAdded == true)
            Toast.makeText(addFoodActivity.this,"Food Added",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(addFoodActivity.this,"Food Not Added",Toast.LENGTH_LONG).show();


        //Clear the food entry form
        foodNameTextbox.getText().clear();
        foodDescriptionTextbox.getText().clear();
        caloriesTextbox.getText().clear();
        fatsTextbox.getText().clear();
        proteinTextbox.getText().clear();
        carbsTextbox.getText().clear();
        servingSizeTextbox.getText().clear();
        servingsSpinner.setSelection(0);
    }

}