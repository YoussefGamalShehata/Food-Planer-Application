package com.example.yumyay_chef.network;

import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.network.allresponses.CategoryMealsResponse;
import com.example.yumyay_chef.network.allresponses.RandomMealResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
    public void makeNetworkCallRandomMeal(NetworkCallBack networkCallBack) {
        mealService.getRandomMeal().enqueue(new Callback<RandomMealResponse>() {
            @Override
            public void onResponse(Call<RandomMealResponse> call, Response<RandomMealResponse> response) {
                if(response.isSuccessful()){
                    networkCallBack.onSuccessResult(response.body().getMeals());
                }
            }

            @Override
            public void onFailure(Call<RandomMealResponse> call, Throwable throwable) {
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
    public void makeNetworkCallCategoryMeals(NetworkCallBackForCategory networkCallBackForCategory) {
        mealService.getMealCategories().enqueue(new Callback<CategoryMealsResponse>() {
            @Override
            public void onResponse(Call<CategoryMealsResponse> call, Response<CategoryMealsResponse> response) {
                if(response.isSuccessful()){
                    networkCallBackForCategory.onSuccessCategoryResult(response.body().getCategories());
                }
            }

            @Override
            public void onFailure(Call<CategoryMealsResponse> call, Throwable throwable) {
                networkCallBackForCategory.onFailureCategoryResult(throwable.getMessage());
            }
        });
    }
}
