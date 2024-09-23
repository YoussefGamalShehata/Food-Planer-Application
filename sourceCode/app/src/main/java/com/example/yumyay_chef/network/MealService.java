package com.example.yumyay_chef.network;

import com.example.yumyay_chef.network.allresponses.RandomMealResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealService {
    // @GET("search.php")
    // Call<MealResponse> searchMeals(@Query("s") String searchQuery);

    // @GET("categories.php")
    // Call<CategoryResponse> getAllCategories();

    // 3 -  get a random meal
    @GET("random.php")
    Call<RandomMealResponse> getRandomMeal();
}
