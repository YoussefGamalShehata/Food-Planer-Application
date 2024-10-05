package com.example.yumyay_chef.homepage.homepageview;

import com.example.yumyay_chef.model.Category;
<<<<<<< HEAD
import com.example.yumyay_chef.model.Country;
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface HomePageFragmentView {
<<<<<<< HEAD
    public void showMealById(List<Meal> meal);
    public void showMealByIdErrMsg(String error);
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
    public void showRandomMealData(List<Meal> meals);
    public void showRandomMealErrMsg(String error);
    public void showCategoryData(List<Category> meals);
    public void showCategoryErrMsg(String error);
    public void showCategoryMeal(List<Meal> food);
    public void showCategoryMealErrMsg(String error);
<<<<<<< HEAD
    public void showCountryData(List<Country> countries);
    public void showCountryErrMsg(String error);
    public void showMealsByCountryData(List<Meal> meals);
    public void showMealsByCountryErrMsg(String error);
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
}
