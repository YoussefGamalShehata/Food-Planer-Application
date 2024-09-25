package com.example.yumyay_chef.network;

import android.net.ConnectivityManager;

public interface MealRemoteDataSource {
    public void makeNetworkCallRandomMeal(NetworkCallBack networkCallBack);
    public void makeNetworkCallCategoryMeals(NetworkCallBackForCategory networkCallBackForCategory);
}
