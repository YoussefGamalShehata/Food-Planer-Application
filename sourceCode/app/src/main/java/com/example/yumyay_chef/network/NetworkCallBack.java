package com.example.yumyay_chef.network;

import com.example.yumyay_chef.network.allresponses.Meal;

import java.util.List;

public interface NetworkCallBack {
    public void onSuccessResult(List<Meal> meals);
    public void onFailureResult(String errorMsg);
}
