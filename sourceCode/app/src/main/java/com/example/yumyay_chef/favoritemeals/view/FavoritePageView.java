package com.example.yumyay_chef.favoritemeals.view;

import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface FavoritePageView {
    public void showMeal(List<Meal> meal);
    public void showErrMsg(String errorMsg);
}
