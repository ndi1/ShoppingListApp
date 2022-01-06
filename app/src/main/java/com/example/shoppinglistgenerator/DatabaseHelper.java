package com.example.shoppinglistgenerator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.BitSet;

public class DatabaseHelper extends SQLiteOpenHelper {

    //DB declaration
    public static final String DATABASE_NAME = "appData.db";

    //Food Table and Columns
    public static final String FOOD_TABLE_NAME = "foods_table";
    public static final String FOOD_TABLE_COL1 = "FOOD_ID";
    public static final String FOOD_TABLE_COL2 = "FOOD_NAME";
    public static final String FOOD_TABLE_COL3 = "FOOD_DESC";
    public static final String FOOD_TABLE_COL4 = "FOOD_CALS";
    public static final String FOOD_TABLE_COL5 = "FOOD_FATS";
    public static final String FOOD_TABLE_COL6 = "FOOD_CARBS";
    public static final String FOOD_TABLE_COL7 = "FOOD_PROTEIN";
    public static final String FOOD_TABLE_COL8 = "FOOD_SERVINGS";
    public static final String FOOD_TABLE_COL9 = "FOOD_SERVING_TYPE";

    //Recipe Table and Columns
    public static final String RECIPE_TABLE_NAME = "recipe_table";
    public static final String RECIPE_TABLE_COL1 = "RECIPE_ID";
    public static final String RECIPE_TABLE_COL2 = "RECIPE_NAME";
    public static final String RECIPE_TABLE_COL3 = "RECIPE_DESC";

    //Ingredient Table and Columns
    public static final String INGREDIENT_TABLE_NAME = "ingredient_table";
    public static final String INGREDIENT_TABLE_COL1 = "INGREDIENT_ID";
    public static final String INGREDIENT_TABLE_COL2 = "FOOD_ID";
    public static final String INGREDIENT_TABLE_COL3 = "RECIPE_ID";

    public static final String ITEM_TABLE_NAME = "item_table";
    public static final String ITEM_TABLE_COL1 = "ITEM_ID";
    public static final String ITEM_TABLE_COL2 = "ITEM_DESC";

    //Daily Food Table and Columns
    public static final String DAILY_FOOD_TABLE_NAME = "daily_food_table";
    public static final String DAILY_FOOD_TABLE_COL1 = "DAILY_FOOD_ID";
    public static final String DAILY_FOOD_TABLE_COL3 = "FOOD_ID";
    public static final String DAILY_FOOD_TABLE_COL4 = "F00D_DATE";

    //Daily Food Table and Columns
    public static final String DAILY_RECIPE_TABLE_NAME = "daily_recipe_table";
    public static final String DAILY_RECIPE_TABLE_COL1 = "DAILY_RECIPE_ID";
    public static final String DAILY_RECIPE_TABLE_COL3 = "RECIPE_ID";
    public static final String DAILY_RECIPE_TABLE_COL4 = "RECIPE_DATE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);


    }

//Add a food item into the food_table in the ShoppingList Database
    public Boolean addFoods(String foodName, String foodDesc, Double foodCals, Double foodFats,Double foodCarbs, Double foodProtein, Double foodServings, String foodServType){
        String query = "INSERT INTO "+FOOD_TABLE_NAME+" (FOOD_NAME, FOOD_DESC, FOOD_CALS, FOOD_FATS,FOOD_CARBS,FOOD_PROTEIN,FOOD_SERVINGS,FOOD_SERVING_TYPE)";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FOOD_TABLE_COL2,foodName);
        contentValues.put(FOOD_TABLE_COL3,foodDesc);
        contentValues.put(FOOD_TABLE_COL4,foodCals);
        contentValues.put(FOOD_TABLE_COL5,foodFats);
        contentValues.put(FOOD_TABLE_COL6,foodCarbs);
        contentValues.put(FOOD_TABLE_COL7,foodProtein);
        contentValues.put(FOOD_TABLE_COL8,foodServings);
        contentValues.put(FOOD_TABLE_COL9,foodServType);
        long result = db.insert(FOOD_TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    //Method to delete a food from the database
    public Integer deleteFoods(Integer ID){
SQLiteDatabase db = this.getWritableDatabase();
return db.delete(FOOD_TABLE_NAME,"FOOD_ID = ?",new String[] {ID.toString()});
    }


    //Method to query the database for all foods and add them to the arraylist used to populate the food recycleviewer
    public ArrayList createFoodList(ArrayList<Food> foods){
SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from foods_table",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            try {
                Integer foodId = cursor.getInt(0);
                String foodName = cursor.getString(1);
                String foodDesc = cursor.getString(2);
                Double foodCals = cursor.getDouble(3);
                Double foodFats = cursor.getDouble(4);
                Double foodCarbs = cursor.getDouble(5);
                Double foodProtein = cursor.getDouble(6);
                Double foodServings = cursor.getDouble(7);
                String foodServType = cursor.getString(8);
                Food food = new Food(foodId,foodName,foodDesc,foodCals,foodFats,foodCarbs,foodProtein,foodServings,foodServType);
                foods.add(food);
                cursor.moveToNext();
            } catch (Exception e){
                e.printStackTrace();
            }

                   }
        cursor.close();
        db.close();
    return foods;
    }

    //Method to edit a food
    public Boolean editFoods(Integer ID, String foodName, String foodDesc, Double foodCals, Double foodFats,Double foodCarbs, Double foodProtein, Double foodServings, String foodServType){


        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(FOOD_TABLE_COL2,foodName);
        contentValues.put(FOOD_TABLE_COL3,foodDesc);
        contentValues.put(FOOD_TABLE_COL4,foodCals);
        contentValues.put(FOOD_TABLE_COL5,foodFats);
        contentValues.put(FOOD_TABLE_COL6,foodCarbs);
        contentValues.put(FOOD_TABLE_COL7,foodProtein);
        contentValues.put(FOOD_TABLE_COL8,foodServings);
        contentValues.put(FOOD_TABLE_COL9,foodServType);

            db.update(FOOD_TABLE_NAME,contentValues,"FOOD_ID = ?",new String[] {ID.toString()});
            return true;
    }

    //Method to find a food to edit
    public Food findFood(Integer ID){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+FOOD_TABLE_NAME+ " WHERE "+ FOOD_TABLE_COL1 + "=" + ID,null);
        if (cursor != null) {
            cursor.moveToFirst();
            Integer foodId = cursor.getInt(0);
            String foodName = cursor.getString(1);
            String foodDesc = cursor.getString(2);
            Double foodCals = cursor.getDouble(3);
            Double foodFats = cursor.getDouble(4);
            Double foodCarbs = cursor.getDouble(5);
            Double foodProtein = cursor.getDouble(6);
            Double foodServings = cursor.getDouble(7);
            String foodServType = cursor.getString(8);
            Food food = new Food(foodId,foodName,foodDesc,foodCals,foodFats,foodCarbs,foodProtein,foodServings,foodServType);
            return food;
        }
        else return null;
    }





//Method to create the initial database and tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+ FOOD_TABLE_NAME+ " (FOOD_ID INTEGER PRIMARY KEY AUTOINCREMENT,FOOD_NAME TEXT, FOOD_DESC TEXT, FOOD_CALS DOUBLE, FOOD_FATS DOUBLE, FOOD_CARBS DOUBLE," +
                " FOOD_PROTEIN DOUBLE,FOOD_SERVINGS DOUBLE,FOOD_SERVING_TYPE TEXT)");
        db.execSQL("Create Table "+RECIPE_TABLE_NAME+ " (RECIPE_ID INTEGER PRIMARY KEY AUTOINCREMENT, RECIPE_NAME TEXT, RECIPE_DESC TEXT)");
        db.execSQL("Create Table "+INGREDIENT_TABLE_NAME+ " (INGREDIENT_ID INTEGER PRIMARY KEY AUTOINCREMENT, FOOD_ID INTEGER, RECIPE_ID INTEGER, FOREIGN KEY (FOOD_ID) REFERENCES foods_table (FOOD_ID) ON DELETE CASCADE ON UPDATE CASCADE,  " +
                "FOREIGN KEY (RECIPE_ID) REFERENCES recipe_table (RECIPE_ID) ON DELETE CASCADE ON UPDATE CASCADE)");
        db.execSQL("Create Table "+ITEM_TABLE_NAME+ " (ITEM_ID INTEGER PRIMARY KEY AUTOINCREMENT, ITEM_NAME TEXT, ITEM_DESC TEXT)");
        db.execSQL("Create Table "+DAILY_FOOD_TABLE_NAME + " (DAILY_FOOD_ID INTEGER PRIMARY KEY AUTOINCREMENT,FOOD_ID INTEGER, FOOD_DATE TEXT, FOREIGN KEY (FOOD_ID) REFERENCES foods_table (FOOD_ID) ON DELETE CASCADE ON UPDATE CASCADE)");
        db.execSQL("Create Table "+DAILY_RECIPE_TABLE_NAME + " (DAILY_RECIPE_ID INTEGER PRIMARY KEY AUTOINCREMENT,RECIPE_ID INTEGER, RECIPE_DATE TEXT, FOREIGN KEY (RECIPE_ID) REFERENCES recipe_table (RECIPE_ID) ON DELETE CASCADE ON UPDATE CASCADE)");
    }

//Method to upgrade database if needed
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS FOOD_TABLE_NAME");

        onCreate(db);
    }
}
