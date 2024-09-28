package com.example.yumyay_chef.favoritemeals.presnter;

import androidx.lifecycle.LiveData;

import com.example.yumyay_chef.favoritemeals.view.FavoritePageView;
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealsRepositoryImpl;

import java.util.List;

public class FavoritePagePresenterImpl implements FavoritePagePresenter {

    private FavoritePageView _view;
    private MealsRepositoryImpl _repo;

    public FavoritePagePresenterImpl(FavoritePageView view, MealsRepositoryImpl repository) {
        this._view = view;
        this._repo = repository;
    }

    @Override
    public LiveData<List<Meal>> loadFavMeals() {
        return _repo.getStoredMeals();
    }

    @Override
    public void removeMeal(Meal meal) {
        _repo.deleteMeal(meal);
    }
}
