package com.example.yumyay_chef.homepage.homepagepresenter;

import com.example.yumyay_chef.homepage.homepageview.HomaPageActivityCategoryMealsView;
import com.example.yumyay_chef.homepage.homepageview.HomePageActivityRandomMealsView;
import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.MealsRepository;
import com.example.yumyay_chef.network.NetworkCallBack;
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.network.NetworkCallBackForCategory;

import java.util.List;

public class HomePagePresenterImpl implements HomePagePresenter, NetworkCallBack, NetworkCallBackForCategory {

    private HomePageActivityRandomMealsView _randomView;
    private HomaPageActivityCategoryMealsView _categoryView;
    private MealsRepository _repo;


    public HomePagePresenterImpl(HomePageActivityRandomMealsView view,HomaPageActivityCategoryMealsView  _categoryView,MealsRepository repo){
        this._randomView = view;
        this._repo = repo;
        this._categoryView = _categoryView;
    }


    @Override
    public void getRandomMealHP() {
        _repo.getRandomMeal(this);
    }

    @Override
    public void getCategoryMealHP() {
        _repo.getMealCatgories(this);
    }

    @Override
    public void onSuccessResult(List<Meal> meals) {
        _randomView.showRandomMealData(meals);
    }

    @Override
    public void onFailureResult(String errorMsg) {
        _randomView.showRandomMealErrMsg(errorMsg);
    }

    @Override
    public void onSuccessCategoryResult(List<Category> categoryList) {
        _categoryView.showCategoryData(categoryList);
    }

    @Override
    public void onFailureCategoryResult(String errorMsg) {
        _categoryView.showCategoryErrMsg(errorMsg);
    }
}
