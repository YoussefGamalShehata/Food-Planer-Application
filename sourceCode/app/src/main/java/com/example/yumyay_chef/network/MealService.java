package com.example.yumyay_chef.network;

import com.example.yumyay_chef.network.allresponses.CategoryMealsResponse;
import com.example.yumyay_chef.network.allresponses.RandomMealResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealService {
    // @GET("search.php")
    // Call<MealResponse> searchMeals(@Query("s") String searchQuery);

     @GET("categories.php")
     Call<CategoryMealsResponse> getMealCategories();

    @GET("random.php")
    Call<RandomMealResponse> getRandomMeal();
}
