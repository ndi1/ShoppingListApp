package com.example.shoppinglistgenerator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //DB declaration
    public static final String DATABASE_NAME = "List.db";

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

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+ FOOD_TABLE_NAME+ " (FOOD_ID INTEGER PRIMARY KEY AUTOINCREMENT,FOOD_NAME TEXT, FOOD_DESC TEXT, FOOD_CALS INTEGER, FOOD_FATS INTEGER, FOOD_CARBS INTEGER," +
                " FOOD_PROTEIN INTEGER,FOOD_SERVINGS INTEGER,FOOD_SERVING_TYPE TEXT)");
        db.execSQL("Create Table "+RECIPE_TABLE_NAME+ " (RECIPE_ID INTEGER PRIMARY KEY AUTOINCREMENT, RECIPE_NAME TEXT, RECIPE_DESC TEXT)");
        db.execSQL("Create Table "+INGREDIENT_TABLE_NAME+ " (INGREDIENT_ID INTEGER PRIMARY KEY AUTOINCREMENT, FOOD_ID INTEGER, RECIPE_ID INTEGER, FOREIGN KEY (FOOD_ID) REFERENCES foods_table (FOOD_ID) ON DELETE CASCADE ON UPDATE CASCADE,  " +
                "FOREIGN KEY (RECIPE_ID) REFERENCES recipe_table (RECIPE_ID) ON DELETE CASCADE ON UPDATE CASCADE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS FOOD_TABLE_NAME");

        onCreate(db);
    }
}
