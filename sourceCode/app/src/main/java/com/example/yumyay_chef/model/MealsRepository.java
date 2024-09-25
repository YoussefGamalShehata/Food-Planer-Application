package com.example.yumyay_chef.model;

import com.example.yumyay_chef.network.NetworkCallBack;
import com.example.yumyay_chef.network.NetworkCallBackForCategory;

public interface MealsRepository {
    public void getRandomMeal(NetworkCallBack networkCallBack);
    public void getMealCatgories(NetworkCallBackForCategory networkCallBackForCategory);
}
