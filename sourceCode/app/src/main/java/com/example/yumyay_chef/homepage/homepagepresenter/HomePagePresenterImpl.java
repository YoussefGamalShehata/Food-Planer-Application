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


    public HomePagePresenterImpl(HomePageActivityView randomview, MealsRepository repo){
        this._View = randomview;
        this._repo = repo;
    }


    @Override
    public void getRandomMealHP() {
        // Call repository method and pass the inner callback class instance
        _repo.getRandomMeal(new RandomMealCallback());
    }

    @Override
    public void getCategoryMealHP() {
        // Call repository method and pass the inner callback class instance
        _repo.getMealCatgories(new CategoryMealCallback());
    }

    // Inner class for handling random meal callback
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

    // Inner class for handling category meal callback
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
