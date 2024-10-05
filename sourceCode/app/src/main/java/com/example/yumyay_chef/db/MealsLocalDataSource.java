package com.example.yumyay_chef.db;

import androidx.lifecycle.LiveData;

import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealPlan;

import java.util.List;

public interface MealsLocalDataSource {
    void insertMeal(Meal meal);
    void deleteMeal(Meal meal);
    public LiveData<List<Meal>> getAllStoredMeals();
    LiveData<List<MealPlan>> getPlannedFood(String date);
    void insertFoodPlan(MealPlan foodPlan);
    void deleteFoodPlan(MealPlan foodPlan);
    void updateFoodPlan(MealPlan foodPlan);
    void checkProductExists(Meal meal);
}
