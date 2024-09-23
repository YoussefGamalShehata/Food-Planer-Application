package com.example.yumyay_chef.model;

import com.example.yumyay_chef.network.NetworkCallBack;

public interface MealsRepository {
    public void getRandomMeal(NetworkCallBack networkCallBack);
}
