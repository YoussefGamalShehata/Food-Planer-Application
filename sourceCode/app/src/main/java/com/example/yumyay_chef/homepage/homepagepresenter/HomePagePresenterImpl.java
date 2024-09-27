package com.example.yumyay_chef.homepage.homepagepresenter;

import com.example.yumyay_chef.homepage.homepageview.HomePageActivityView;
import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.MealsRepository;
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.network.NetworkCallBack;

import java.util.List;

public class HomePagePresenterImpl implements HomePagePresenter{

    private HomePageActivityView _View;
    private MealsRepository _repo;


    public HomePagePresenterImpl(HomePageActivityView view, MealsRepository repo){
        this._View = view;
        this._repo = repo;
    }


    @Override
    public void getRandomMealHP() {
        _repo.getRandomMeal(new RandomMealCallback());
    }

    @Override
    public void getCategoryMealHP() {
        _repo.getMealCategories(new CategoryMealCallback());
    }

    private class RandomMealCallback implements NetworkCallBack<Meal> {
        @Override
        public void onSuccessResult(List<Meal> pojo) {
            _View.showRandomMealData(pojo);
        }

        @Override
        public void onFailureResult(String errorMsg) {
            _View.showRandomMealErrMsg(errorMsg);
        }
    }

    private class CategoryMealCallback implements NetworkCallBack<Category> {
        @Override
        public void onSuccessResult(List<Category> pojo) {
            _View.showCategoryData(pojo);
        }

        @Override
        public void onFailureResult(String errorMsg) {
            _View.showCategoryErrMsg(errorMsg);
        }
    }



}
