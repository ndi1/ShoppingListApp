package com.example.shoppinglistgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class createListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        //Testing ListView
        final ListView shoppingListView = (ListView) findViewById(R.id.shoppingListView);
        String[] items = new String[]{
                "Item 1",
                "Item 2",
        };

        final List<String> shopping_list = new ArrayList<String>(Arrays.asList(items));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,shopping_list);
        shoppingListView.setAdapter(arrayAdapter);
//Testing ListView


    }
}