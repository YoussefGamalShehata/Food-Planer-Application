package com.example.yumyay_chef.model;

import androidx.lifecycle.LiveData;

import com.example.yumyay_chef.network.NetworkCallBack;

import java.util.List;

public interface MealsRepository {
    public LiveData<List<Meal>> getStoredMeals();
    public void insertMeal(Meal meal);
    public void deleteMeal(Meal meal);
    public void getRandomMeal(NetworkCallBack<Meal> networkCallBack);
    public void getMealCategories(NetworkCallBack<Category> networkCallBack);
    public void getMealById(String id , NetworkCallBack<Meal> callback);
    public void getMealByCategory(String id , NetworkCallBack<Meal> callback);
    public void getMealByCountry(String country , NetworkCallBack<Meal> callback);
    public void getMealByIngredient(String ingredient , NetworkCallBack<Meal> callback);
    public void getMealByName(String name , NetworkCallBack<Meal>callback);
    public LiveData<List<MealPlan>> getPlannedMeal(String date);
    public void insertMealPlan(MealPlan mealPlan);
    public void deleteMealPlan(MealPlan mealPlan);
   // public void updateFoodPlan(MealPlan foodPlan);
    public void getFlagCountries(NetworkCallBack<Country> callback);
    public void checkFoodExists(Meal meal);
}
