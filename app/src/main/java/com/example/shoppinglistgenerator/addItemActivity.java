package com.example.shoppinglistgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addItemActivity extends AppCompatActivity {

    private FloatingActionButton addItemButton;
    private EditText itemNameTextbox,itemDescriptionTextbox;
    private DatabaseHelper myDB;
    private String itemName;
    private String itemDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_add_item);
        myDB = new DatabaseHelper(this);

        addItemButton = findViewById(R.id.addItemFAB);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

    }

    public void addItem(){
        itemNameTextbox = findViewById(R.id.itemNameTextbox);
        itemDescriptionTextbox = findViewById(R.id.itemDescriptionTextbox);

        itemDesc = itemDescriptionTextbox.getText().toString();
        itemName = itemNameTextbox.getText().toString();

        Boolean isAdded = myDB.addItems(itemName,itemDesc);
        if (isAdded == true)
            Toast.makeText(addItemActivity.this,"Item Added",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(addItemActivity.this,"Item Not Added",Toast.LENGTH_LONG).show();

        //Clear the item entry form
        itemNameTextbox.getText().clear();
        itemDescriptionTextbox.getText().clear();

    }



}