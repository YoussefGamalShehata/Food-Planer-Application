package com.example.yumyay_chef.search.presenter;

import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealsRepository;
import com.example.yumyay_chef.network.NetworkCallBack;
import com.example.yumyay_chef.search.view.SearchFragmentView;

import java.util.List;

public class SearchPresenterImpl implements SearchPresenter, NetworkCallBack<Meal> {

    private MealsRepository _repo;
    private SearchFragmentView _view;

    public SearchPresenterImpl(SearchFragmentView _view, MealsRepository _repo) {
        this._repo = _repo;
        this._view = _view;
    }

    @Override
    public void getMealByCategory(String id) {
        _repo.getMealByCategory(id,this);
    }

    @Override
    public void getMealById(String id) {
    _repo.getMealById(id,this);
    }

    @Override
    public void getMealName(String name) {
    _repo.getMealByName(name,this);
    }

    @Override
    public void getMealByCountry(String country) {
    _repo.getMealByCountry(country,this);
    }

    @Override
    public void getMealByIngredient(String ingredent) {
    _repo.getMealByIngredient(ingredent,this);
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
