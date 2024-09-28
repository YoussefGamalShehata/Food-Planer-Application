package com.example.yumyay_chef.favoritemeals.presnter;

import androidx.lifecycle.LiveData;

import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface FavoritePagePresenter {
    public LiveData<List<Meal>> loadFavMeals();
    public void removeMeal(Meal meal);
}
