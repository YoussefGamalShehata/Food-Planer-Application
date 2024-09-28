package com.example.yumyay_chef.db;

import androidx.lifecycle.LiveData;

import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface MealsLocalDataSource {
    void insertMeal(Meal meal);
    void deleteMeal(Meal meal);
    public LiveData<List<Meal>> getAllStoredMeals();
}
