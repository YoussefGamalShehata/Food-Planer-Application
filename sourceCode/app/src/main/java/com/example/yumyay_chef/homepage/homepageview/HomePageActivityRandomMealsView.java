package com.example.yumyay_chef.homepage.homepageview;

import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface HomePageActivityRandomMealsView {
    public void showRandomMealData(List<Meal> meals);
    public void showRandomMealErrMsg(String error);
}
