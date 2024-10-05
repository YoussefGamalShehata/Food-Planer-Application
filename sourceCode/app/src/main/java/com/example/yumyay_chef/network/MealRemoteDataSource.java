package com.example.yumyay_chef.network;

import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Country;
import com.example.yumyay_chef.model.Meal;

public interface MealRemoteDataSource {
    public void makeNetworkCallRandomMeal(NetworkCallBack<Meal> networkCallBack);
    public void makeNetworkCallCategoryMeal(NetworkCallBack<Category> networkCallBack);
    public void makeNetworkCallCategoryMealById(String category , NetworkCallBack<Meal> networkCallBack);
    public void makeNetworkCallCountryMealById(String country , NetworkCallBack<Meal> networkCallBack);
    public void makeNetworkCallMealByName(String name , NetworkCallBack<Meal> networkCallBack);

    public void makeNetworkCallIngradiant(String ingrediant , NetworkCallBack<Meal> networkCallBack);
<<<<<<< HEAD
    public void makeNetworkCallMealById(String id , NetworkCallBack<Meal> networkCallBack);

    public void makeNetworkCallFlagCountries(NetworkCallBack<Country> networkCallBack);
=======
    public void makeNetworkCallFoodById(String id , NetworkCallBack<Meal> networkCallBack);
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
}
