package com.example.yumyay_chef.network;

import android.net.ConnectivityManager;

import com.example.yumyay_chef.model.Meal;

public interface MealRemoteDataSource {
    public void makeNetworkCallRandomMeal(NetworkCallBack<Meal> networkCallBack);
}
