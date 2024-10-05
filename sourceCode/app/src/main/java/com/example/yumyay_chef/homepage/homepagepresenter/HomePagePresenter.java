package com.example.yumyay_chef.homepage.homepagepresenter;

import com.example.yumyay_chef.model.Meal;

public interface HomePagePresenter {
    public void getRandomMealHP();
    public void getCategoryMealHP();
    public void getMealsByCategoryHP(String id);
    public void getCountryHP();
    public void getMealsByCountryHP(String country);
    public void getMealById(String id);
    public void addToFav(Meal meal);

    public void removeFromFav(Meal meal);
}
