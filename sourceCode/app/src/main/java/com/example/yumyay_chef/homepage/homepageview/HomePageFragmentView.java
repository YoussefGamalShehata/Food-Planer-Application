package com.example.yumyay_chef.homepage.homepageview;

import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Country;
import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface HomePageFragmentView {
    public void showMealById(List<Meal> meal);
    public void showMealByIdErrMsg(String error);
    public void showRandomMealData(List<Meal> meals);
    public void showRandomMealErrMsg(String error);
    public void showCategoryData(List<Category> meals);
    public void showCategoryErrMsg(String error);
    public void showCategoryMeal(List<Meal> food);
    public void showCategoryMealErrMsg(String error);
    public void showCountryData(List<Country> countries);
    public void showCountryErrMsg(String error);
    public void showMealsByCountryData(List<Meal> meals);
    public void showMealsByCountryErrMsg(String error);
}
