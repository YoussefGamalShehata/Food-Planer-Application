package com.example.yumyay_chef.network;

import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Country;
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

    @GET("filter.php")
    Call<AppResponse<Meal>> getMealByIngredient(@Query("i") String ingredient);

    @GET("filter.php")
    Call<AppResponse<Meal>> getMealByCountry(@Query("a") String country);

    @GET("lookup.php")
    Call<AppResponse<Meal>> getMealById(@Query("i") String id);

    @GET("search.php")
<<<<<<< HEAD
    Call<AppResponse<Meal>> getMealByName(@Query("s") String mealName);

    @GET("list.php?a=list")
    Call<AppResponse<Country>> getCountries();
=======
    Call<AppResponse<Meal>> getFoodByName(@Query("s") String mealName);

>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
}
