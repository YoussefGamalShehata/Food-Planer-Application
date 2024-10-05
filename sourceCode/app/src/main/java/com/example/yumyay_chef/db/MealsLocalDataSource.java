package com.example.yumyay_chef.db;

import androidx.lifecycle.LiveData;

import com.example.yumyay_chef.model.Meal;
<<<<<<< HEAD
import com.example.yumyay_chef.model.MealPlan;
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a

import java.util.List;

public interface MealsLocalDataSource {
    void insertMeal(Meal meal);
    void deleteMeal(Meal meal);
    public LiveData<List<Meal>> getAllStoredMeals();
<<<<<<< HEAD
    LiveData<List<MealPlan>> getPlannedFood(String date);
    void insertFoodPlan(MealPlan foodPlan);
    void deleteFoodPlan(MealPlan foodPlan);
    void updateFoodPlan(MealPlan foodPlan);
    void checkProductExists(Meal meal);
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
}
