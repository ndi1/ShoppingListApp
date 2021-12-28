package com.example.shoppinglistgenerator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "List.db";
    public static final String FOOD_TABLE_NAME = "foods_table";
    public static final String FOOD_TABLE_NAME_COL1 = "FOOD_ID";
    public static final String FOOD_TABLE_NAME_COL2 = "FOOD_NAME";
    public static final String FOOD_TABLE_NAME_COL3 = "FOOD_DESC";
    public static final String FOOD_TABLE_NAME_COL4 = "FOOD_CALS";
    public static final String FOOD_TABLE_NAME_COL5 = "FOOD_FATS";
    public static final String FOOD_TABLE_NAME_COL6 = "FOOD_CARBS";
    public static final String FOOD_TABLE_NAME_COL7 = "FOOD_PROTEIN";
    public static final String FOOD_TABLE_NAME_COL8 = "FOOD_SERVINGS";
    public static final String FOOD_TABLE_NAME_COL9 = "FOOD_SERVING_TYPE";






    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+ FOOD_TABLE_NAME+ " (FOOD_ID INTEGER PRIMARY KEY AUTOINCREMENT,FOOD_NAME TEXT, FOOD_DESC TEXT, FOOD_CALS INTEGER, FOOD_FATS INTEGER, FOOD_CARBS INTEGER," +
                " FOOD_PROTEIN INTEGER,FOOD_SERVINGS INTEGER,FOOD_SERVING_TYPE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS FOOD_TABLE_NAME");
        onCreate(db);
    }
}
