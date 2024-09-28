package com.example.yumyay_chef.homepage.homepageview;

import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface HomePageFragmentView {
    public void showRandomMealData(List<Meal> meals);
    public void showRandomMealErrMsg(String error);
    public void showCategoryData(List<Category> meals);
    public void showCategoryErrMsg(String error);
}
