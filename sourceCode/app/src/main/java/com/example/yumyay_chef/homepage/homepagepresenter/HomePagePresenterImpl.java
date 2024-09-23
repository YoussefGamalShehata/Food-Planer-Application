package com.example.yumyay_chef.homepage.homepagepresenter;

import com.example.yumyay_chef.homepage.homepageview.HomePageActivityView;
import com.example.yumyay_chef.model.MealsRepository;
import com.example.yumyay_chef.network.NetworkCallBack;
import com.example.yumyay_chef.network.allresponses.Meal;

import java.util.List;

public class HomePagePresenterImpl implements HomePagePresenter, NetworkCallBack {

    private HomePageActivityView _view;
    private MealsRepository _repo;


    public HomePagePresenterImpl(HomePageActivityView view , MealsRepository repo){
        this._view = view;
        this._repo = repo;
    }


    @Override
    public void getRandomMealHP() {
        _repo.getRandomMeal(this);
    }

    @Override
    public void onSuccessResult(List<Meal> meals) {
        _view.showData(meals);
    }

    @Override
    public void onFailureResult(String errorMsg) {
        _view.showErrMsg(errorMsg);
    }
}
