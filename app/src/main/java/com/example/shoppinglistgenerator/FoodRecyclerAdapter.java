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
    private OnFoodListener mOnFoodListener;


    public FoodRecyclerAdapter(Context c, ArrayList<Food> foods,OnFoodListener onFoodListener){
            context = c;
            foodList = foods;
            this.mOnFoodListener = onFoodListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.food_row,parent,false);
        return new MyViewHolder(view,mOnFoodListener);
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

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView foodName;

        OnFoodListener onFoodListener;
        public MyViewHolder(@NonNull View itemView,OnFoodListener onFoodListener) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            itemView.setOnClickListener(this);
            this.onFoodListener = onFoodListener;
        }

        @Override
        public void onClick(View v) {
        onFoodListener.onFoodClick(getAdapterPosition());
        }
    }
    public interface OnFoodListener{
        void onFoodClick(int position);
    }
}


