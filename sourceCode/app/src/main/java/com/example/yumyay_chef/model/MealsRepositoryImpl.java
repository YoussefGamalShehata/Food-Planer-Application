package com.example.yumyay_chef.model;

import androidx.lifecycle.LiveData;

import com.example.yumyay_chef.db.MealsLocalDataSource;
import com.example.yumyay_chef.network.MealRemoteDataSource;
import com.example.yumyay_chef.network.NetworkCallBack;

import java.util.List;

public class MealsRepositoryImpl implements MealsRepository{

    MealRemoteDataSource remoteSource;
    MealsLocalDataSource localDataSource;
    private static MealsRepositoryImpl repo = null;

    private MealsRepositoryImpl (MealRemoteDataSource remoteSource , MealsLocalDataSource localDataSource)
    {
        this.remoteSource = remoteSource;
        this.localDataSource = localDataSource;
    }

    public static MealsRepositoryImpl getInstance(MealRemoteDataSource remoteSource , MealsLocalDataSource localDataSource)
    {
        if(repo == null)
        {
            repo = new MealsRepositoryImpl(remoteSource,localDataSource);
        }
        return repo;
    }

    @Override
    public LiveData<List<Meal>> getStoredMeals() {
        return localDataSource.getAllStoredMeals();
    }

    @Override
    public void insertMeal(Meal meal) {
        localDataSource.insertMeal(meal);
    }

    @Override
    public void deleteMeal(Meal meal) {
        localDataSource.deleteMeal(meal);
    }

    @Override
    public void getRandomMeal(NetworkCallBack<Meal> networkCallBack) {
        remoteSource.makeNetworkCallRandomMeal(networkCallBack);
    }

    @Override
    public void getMealCategories(NetworkCallBack<Category> networkCallBack) {
        remoteSource.makeNetworkCallCategoryMeal(networkCallBack);
    }

    @Override
    public void getMealById(String id, NetworkCallBack<Meal> callback) {
        remoteSource.makeNetworkCallMealById(id,callback);
    }
    @Override
    public void getMealByCategory(String id, NetworkCallBack<Meal> callback) {
        remoteSource.makeNetworkCallCategoryMealById(id,callback);
    }

    @Override
    public void getMealByCountry(String country, NetworkCallBack<Meal> callback) {
        remoteSource.makeNetworkCallCountryMealById(country,callback);
    }

    @Override
    public void getMealByIngredient(String ingredient, NetworkCallBack<Meal> callback) {
        remoteSource.makeNetworkCallIngradiant(ingredient,callback);
    }
    @Override
    public void getMealByName(String name, NetworkCallBack<Meal> callback) {
        remoteSource.makeNetworkCallMealByName(name,callback);
    }

    @Override
    public LiveData<List<MealPlan>> getPlannedMeal(String date) {
        return localDataSource.getPlannedFood(date);
    }

    @Override
    public void insertMealPlan(MealPlan mealPlan) {
        localDataSource.insertFoodPlan(mealPlan);
    }

    @Override
    public void deleteMealPlan(MealPlan mealPlan) {
        localDataSource.deleteFoodPlan(mealPlan);
    }

//    @Override
//    public void updateFoodPlan(MealPlan foodPlan) {
//        localDataSource.updateFoodPlan(foodPlan);
//    }

    @Override
    public void getFlagCountries(NetworkCallBack<Country> callback) {
        remoteSource.makeNetworkCallFlagCountries(callback);
    }

    @Override
    public void checkFoodExists(Meal meal) {
        localDataSource.checkProductExists(meal);
    }
}
