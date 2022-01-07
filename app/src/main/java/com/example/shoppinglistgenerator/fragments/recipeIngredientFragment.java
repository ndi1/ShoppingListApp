package com.example.shoppinglistgenerator.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.shoppinglistgenerator.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class recipeIngredientFragment extends Fragment {




    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public recipeIngredientFragment() {

    }


    public static recipeIngredientFragment newInstance(String param1, String param2) {
        recipeIngredientFragment fragment = new recipeIngredientFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_ingredient, container, false);


        //Testing ListView
        ListView lv = (ListView) view.findViewById (R.id.recipeIngredientListView);
        String[] items = new String[]{
                "Item 1",
                "Item 2",
        };
        List<String> item_list = new ArrayList<String>(Arrays.asList(items));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1,items
        );
        lv.setAdapter(arrayAdapter);

        return view;

//Testing ListView
    }
}