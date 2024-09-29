package com.example.yumyay_chef.search.presenter;

public interface SearchPresnter {
    public void getFoodByCategory(String id);
    public void getFoodById(String id);
    public void getFoodName(String name);
    public void getFoodByCountry(String country);
    public void getFoodByIngredient(String ingredent);
}
