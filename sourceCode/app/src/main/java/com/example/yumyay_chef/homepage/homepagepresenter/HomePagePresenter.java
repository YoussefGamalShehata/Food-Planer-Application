package com.example.yumyay_chef.homepage.homepagepresenter;

public interface HomePagePresenter {
    public void getRandomMealHP();
    public void getCategoryMealHP();
    public void getMealsByCategoryHP(String id);
    public void getCountryHP();
    public void getMealsByCountryHP(String country);
    public void getMealById(String id);
}
