package com.example.yumyay_chef.network;

import androidx.annotation.NonNull;

import com.example.yumyay_chef.model.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealRemoteDataSourceImpl implements MealRemoteDataSource{
    private static final String TAG = "MealsActivity";
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private MealService mealService;
    private static MealRemoteDataSourceImpl client = null;
    private List<Meal> mealList;

    private MealRemoteDataSourceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mealService = retrofit.create(MealService.class);
    }

    public static MealRemoteDataSourceImpl getInstance() {
        if (client == null) {
            client = new MealRemoteDataSourceImpl();
        }
        return client;
    }

    @Override
    public void makeNetworkCallRandomMeal(NetworkCallBack<Meal> networkCallBack) {
        mealService.getRandomMeal().enqueue(new Callback<AppResponse<Meal>>() {

            @Override
            public void onResponse(@NonNull Call<AppResponse<Meal>> call, @NonNull retrofit2.Response<AppResponse<Meal>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallBack.onSuccessResult(response.body().meals);
                } else {
                    networkCallBack.onFailureResult("Failed to get random meal");
                }
            }

            @Override
            public void onFailure(Call<AppResponse<Meal>> call, Throwable throwable) {
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });

    }
}
