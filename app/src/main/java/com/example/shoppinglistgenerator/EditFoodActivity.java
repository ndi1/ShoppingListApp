package com.example.shoppinglistgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shoppinglistgenerator.entities.Food;
import com.example.shoppinglistgenerator.helpers.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;

public class EditFoodActivity extends AppCompatActivity implements Serializable{

    //Vairable initialization
    DatabaseHelper myDb;
    private FloatingActionButton editFoodButton;
    private EditText foodNameTextbox,foodDescriptionTextbox,caloriesTextbox,fatsTextbox,carbsTextbox,proteinTextbox,servingSizeTextbox;
    private Spinner servingsSpinnerEdit;
    private String spinnerSelection,foodName,foodDescText;
    private Double calDouble, fatsDouble, carbsDouble, proteinDouble, servingsDouble;
    private Food updatedFood;
    private Integer foodID;

    //Method called when the activity is created (setup method)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_edit_food);

        Food editedFood = (Food) getIntent().getSerializableExtra("Food");
        myDb = new DatabaseHelper(this);


        editFoodButton = findViewById(R.id.saveFoodEdit);
        foodNameTextbox = findViewById(R.id.foodNameTextboxEdit);
        foodDescriptionTextbox = findViewById(R.id.foodDescriptionTextboxEdit);
        caloriesTextbox = findViewById(R.id.caloriesTextboxEdit);
        fatsTextbox = findViewById(R.id.fatsTextboxEdit);
        carbsTextbox = findViewById(R.id.carbsTextboxEdit);
        proteinTextbox = findViewById(R.id.proteinTextboxEdit);
        servingSizeTextbox = findViewById(R.id.servingSizeTextboxEdit);
        servingsSpinnerEdit = findViewById(R.id.servingSpinnerEdit);


        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.servings, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        servingsSpinnerEdit.setAdapter(adapter);
        String servCompare = editedFood.getServingType();

        if (servCompare != null){
            int position = adapter.getPosition(servCompare);
            servingsSpinnerEdit.setSelection(position);
        }


        foodID = editedFood.getFoodId();
        foodNameTextbox.setText(editedFood.getFoodName());
        foodDescriptionTextbox.setText(editedFood.getFoodDesc());
        caloriesTextbox.setText(editedFood.getFoodCal().toString());
        fatsTextbox.setText(editedFood.getFoodFats().toString());
        carbsTextbox.setText(editedFood.getFoodCarbs().toString());
        proteinTextbox.setText(editedFood.getFoodProtein().toString());
        servingSizeTextbox.setText(editedFood.getServingSize().toString());




    //On click listener for save button to edit selected foods
        editFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    foodName = foodNameTextbox.getText().toString();
                    foodDescText = foodDescriptionTextbox.getText().toString();
                    calDouble =  Double.parseDouble(caloriesTextbox.getText().toString());
                    fatsDouble =  Double.parseDouble(fatsTextbox.getText().toString());
                    carbsDouble =  Double.parseDouble(carbsTextbox.getText().toString());
                    proteinDouble =  Double.parseDouble(proteinTextbox.getText().toString());
                    servingsDouble =  Double.parseDouble(servingSizeTextbox.getText().toString());
                    spinnerSelection = servingsSpinnerEdit.getSelectedItem().toString();


                    myDb.editFoods(foodID,foodName,foodDescText,calDouble,fatsDouble,carbsDouble,proteinDouble,servingsDouble,spinnerSelection);
                } catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Incorrect Data Types",Toast.LENGTH_LONG).show();
                }

                returnToSearch();

            }
        });

    }

    //Method to return to the food search activity
public void returnToSearch(){
    Intent intent = new Intent(this, foodSearchActivity.class);
    startActivity(intent);
}

}