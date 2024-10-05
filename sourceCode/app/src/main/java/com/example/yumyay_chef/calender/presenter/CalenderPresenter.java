package com.example.yumyay_chef.calender.presenter;

import androidx.lifecycle.LiveData;

import com.example.yumyay_chef.model.MealPlan;

import java.util.List;

public interface CalenderPresenter {
    public LiveData<List<MealPlan>> getPlanedFood(String date);
    public void removeFromFav(MealPlan foodPlan);
}

