package com.example.yumyay_chef.model;

import com.example.yumyay_chef.network.MealRemoteDataSource;
import com.example.yumyay_chef.network.NetworkCallBack;
import com.example.yumyay_chef.network.MealRemoteDataSource;
import com.example.yumyay_chef.network.NetworkCallBack;
import com.example.yumyay_chef.network.NetworkCallBackForCategory;

public class MealsRepositoryImpl implements MealsRepository{

    MealRemoteDataSource remoteSource;
    private static MealsRepositoryImpl repo = null;

    private MealsRepositoryImpl (MealRemoteDataSource remoteSource)
    {
        this.remoteSource = remoteSource;
    }

    public static MealsRepositoryImpl getInstance(MealRemoteDataSource remoteSource)
    {
        if(repo == null)
        {
            repo = new MealsRepositoryImpl(remoteSource);
        }
        return repo;
    }

    @Override
    public void getRandomMeal(NetworkCallBack<Meal> networkCallBack) {
        remoteSource.makeNetworkCallRandomMeal(networkCallBack);
    }


//    @Override
//    public void getMealCatgories(NetworkCallBackForCategory networkCallBackForCategory) {
//        remoteSource.makeNetworkCallCategoryMeals(networkCallBackForCategory);
//    }
}
