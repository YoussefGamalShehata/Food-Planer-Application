package com.example.yumyay_chef.network;

import android.net.ConnectivityManager;

import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Meal;

public interface MealRemoteDataSource {
    public void makeNetworkCallRandomMeal(NetworkCallBack<Meal> networkCallBack);
    public void makeNetworkCallCategoryMeal(NetworkCallBack<Category> networkCallBack);
    public void makeNetworkCallCategoryMealById(String category , NetworkCallBack<Meal> networkCallBack);
}
