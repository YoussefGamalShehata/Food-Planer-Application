package com.example.yumyay_chef.search.presenter;

public interface SearchPresenter {
    public void getMealByCategory(String id);
    public void getMealById(String id);
    public void getMealName(String name);
    public void getMealByCountry(String country);
    public void getMealByIngredient(String ingredent);
}
