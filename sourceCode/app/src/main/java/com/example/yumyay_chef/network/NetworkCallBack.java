package com.example.yumyay_chef.network;

import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface NetworkCallBack<T> {
    public void onSuccessResult(List<T> meals);
    public void onFailureResult(String errorMsg);
}
