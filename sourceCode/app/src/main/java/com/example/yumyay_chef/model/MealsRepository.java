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
    void getMealById(String id , NetworkCallBack<Meal> callback);
    void getMealByCategory(String id , NetworkCallBack<Meal> callback);
    void getMealByCountry(String country , NetworkCallBack<Meal> callback);
    void getMealByIngredient(String ingredient , NetworkCallBack<Meal> callback);
    void getMealByName(String name , NetworkCallBack<Meal>callback);
}
