package com.example.shoppinglistgenerator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodRecyclerAdapter.MyViewHolder> implements Filterable {

    Context context;
    ArrayList<Food> foodList;
    ArrayList<Food> foodListFull;
    private OnFoodListener mOnFoodListener;

//Adapter constructer with onCLickListener
    public FoodRecyclerAdapter(Context c, ArrayList<Food> foods,OnFoodListener onFoodListener){
            context = c;
            foodList = foods;
            this.mOnFoodListener = onFoodListener;
            foodListFull = new ArrayList<Food>(foodList);
    }

    //Inflates the view when created
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.food_row,parent,false);
        return new MyViewHolder(view,mOnFoodListener);
    }

    //Sets text within recyclerview cards
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodName.setText(food.getFoodName());
        holder.foodDesc.setText(food.getFoodDesc());
        holder.foodCal.setText(food.getFoodCal().toString()+" Cals");

    }

    @Override
    public int getItemCount() {
        return foodList == null ? 0: foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView foodName;
        TextView foodDesc;
        TextView foodCal;

        OnFoodListener onFoodListener;
        public MyViewHolder(@NonNull View itemView,OnFoodListener onFoodListener) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            foodDesc = itemView.findViewById(R.id.foodDesc);
            foodCal = itemView.findViewById(R.id.foodCal);
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

    public Filter getFilter(){
        return foodListFilter;
    }

    private Filter foodListFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Food> filteredFoodList = new ArrayList<>();

            if (constraint == null || constraint.length()==0){
                filteredFoodList.addAll(foodListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Food f: foodListFull){
                    if (f.getFoodName().toLowerCase().contains(filterPattern)){
                        filteredFoodList.add(f);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredFoodList;
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            foodList.clear();
            foodList.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };
}


