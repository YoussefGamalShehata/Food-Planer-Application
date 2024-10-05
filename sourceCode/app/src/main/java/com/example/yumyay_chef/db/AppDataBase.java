package com.example.yumyay_chef.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.yumyay_chef.model.Meal;
<<<<<<< HEAD
import com.example.yumyay_chef.model.MealPlan;

@Database(entities = {Meal.class, MealPlan.class}, version = 1)
=======

@Database(entities = {Meal.class}, version = 1)
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
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
