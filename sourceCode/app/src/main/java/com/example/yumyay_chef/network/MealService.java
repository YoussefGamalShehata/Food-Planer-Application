package com.example.yumyay_chef.network;

import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Meal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {
    // 1 - get the list of categories
    @GET("categories.php")
    Call<AppResponse<Category>> getMealCategories();
    // 3 -  get a random meal
    @GET("random.php")
    Call<AppResponse<Meal>> getRandomMeal();
    @GET("filter.php")
    Call<AppResponse<Meal>> getMealByIdCategory(@Query("c") String category);

}
