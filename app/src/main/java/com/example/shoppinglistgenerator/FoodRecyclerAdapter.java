package com.example.shoppinglistgenerator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodRecyclerAdapter.MyViewHolder>{

    Context context;
    ArrayList<Food> foodList;


    public FoodRecyclerAdapter(Context c, ArrayList<Food> foods){
            context = c;
            foodList = foods;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.food_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodName.setText(food.getFoodName());
    }

    @Override
    public int getItemCount() {
        return foodList == null ? 0: foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView foodName;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
        }
    }
}


