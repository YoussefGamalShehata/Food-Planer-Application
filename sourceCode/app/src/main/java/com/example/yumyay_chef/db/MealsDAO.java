package com.example.yumyay_chef.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.yumyay_chef.model.Meal;

import java.util.List;
@Dao
public interface MealsDAO {
    @Query("SELECT * FROM meal_table")
    LiveData<List<Meal>> getAllMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMeal(Meal product);

    @Delete
    void deleteMeal(Meal product);
}
