package com.example.yumyay_chef.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealPlan;

@Database(entities = {Meal.class, MealPlan.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance = null;
    public abstract MealsDAO getMealDAO();
    public static synchronized AppDataBase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class, "mealsdb").build();
        }
        return instance;
    }
}
