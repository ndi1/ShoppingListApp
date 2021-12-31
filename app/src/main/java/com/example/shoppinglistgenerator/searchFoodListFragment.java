package com.example.shoppinglistgenerator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;


public class searchFoodListFragment extends Fragment implements FoodRecyclerAdapter.OnFoodListener {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private ArrayList<Food> foods = new ArrayList<Food>();
    private FoodRecyclerAdapter foodRecyclerAdapter;


    private String mParam1;
    private String mParam2;

    public searchFoodListFragment() {
        // Required empty public constructor
    }


    private void loadFoods(){
        DatabaseHelper databaseHelper = new DatabaseHelper(this.getContext());
        databaseHelper.createFoodList(foods);
    }

    public static searchFoodListFragment newInstance(String param1, String param2) {
        searchFoodListFragment fragment = new searchFoodListFragment();
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
        View view = inflater.inflate(R.layout.fragment_search_food_list, container, false);
        recyclerView = view.findViewById(R.id.foodListRV);
        loadFoods();
       foodRecyclerAdapter = new FoodRecyclerAdapter(this.getContext(),foods,this);
        recyclerView.setAdapter(foodRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        setHasOptionsMenu(true);


        return view;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
       inflater = getActivity().getMenuInflater();
       inflater.inflate(R.menu.food_search_menu,menu);
       MenuItem searchItem = menu.findItem(R.id.foodSearch);
       SearchView searchView = (SearchView) searchItem.getActionView();
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               foodRecyclerAdapter.getFilter().filter(newText);
               return false;
           }
       });
    }



    @Override
    public void onFoodClick(int position) {
        foods.get(position);
    }
}