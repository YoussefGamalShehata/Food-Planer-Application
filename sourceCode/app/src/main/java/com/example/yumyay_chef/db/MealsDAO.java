package com.example.yumyay_chef.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealPlan;

import java.util.List;
@Dao
public interface MealsDAO {
    @Query("SELECT * FROM meal_table")
    LiveData<List<Meal>> getAllMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMeal(Meal product);

    @Delete
    void deleteMeal(Meal product);

    @Query("SELECT EXISTS(SELECT 1 FROM meal_table WHERE mealId = :MealId)")
    boolean isMealExists(String MealId);
    ///////////////////
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMealPlan(MealPlan foodPlan);

    @Query("SELECT * FROM meal_plan WHERE date = :date")
    LiveData<List<MealPlan>> getPlannedFood(String date);

    @Delete
    void deleteMealPlan(MealPlan foodPlan);
    @Update
    void updateMealPlan(MealPlan foodPlan);

}
