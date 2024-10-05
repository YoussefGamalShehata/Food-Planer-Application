package com.example.yumyay_chef.network;

import androidx.annotation.NonNull;

import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Country;
import com.example.yumyay_chef.model.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MealRemoteDataSourceImpl implements MealRemoteDataSource{
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private MealService mealService;
    private static MealRemoteDataSourceImpl client = null;

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
            public void onFailure(@NonNull Call<AppResponse<Meal>> call, @NonNull Throwable throwable) {
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });

    }
    @Override
    public void makeNetworkCallCategoryMeal(NetworkCallBack<Category> networkCallback) {
        mealService.getMealCategories().enqueue(new Callback<AppResponse<Category>>() {

            @Override
            public void onResponse(@NonNull Call<AppResponse<Category>> call, @NonNull retrofit2.Response<AppResponse<Category>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallback.onSuccessResult(response.body().categories);
                } else {
                    networkCallback.onFailureResult("Failed to fetch category");
                }
            }

            @Override
            public void onFailure(@NonNull Call<AppResponse<Category>> call, @NonNull Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
    public void makeNetworkCallCategoryMealById(String category, NetworkCallBack<Meal> networkCallBack) {
        mealService.getMealByIdCategory(category).enqueue(new Callback<AppResponse<Meal>>() {
            @Override
<<<<<<< HEAD
            public void onResponse(@NonNull Call<AppResponse<Meal>> call, @NonNull Response<AppResponse<Meal>> response) {
=======
            public void onResponse(Call<AppResponse<Meal>> call, Response<AppResponse<Meal>> response) {
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
                if (response.isSuccessful() && response.body() != null) {
                    networkCallBack.onSuccessResult(response.body().meals);
                } else {
                    networkCallBack.onFailureResult("Failed to fetch category");
                }
            }

            @Override
<<<<<<< HEAD
            public void onFailure(@NonNull Call<AppResponse<Meal>> call, @NonNull Throwable throwable) {
=======
            public void onFailure(Call<AppResponse<Meal>> call, Throwable throwable) {
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
    public void makeNetworkCallCountryMealById(String country, NetworkCallBack<Meal> networkCallBack) {
        mealService.getMealByCountry(country).enqueue(new Callback<AppResponse<Meal>>() {

            @Override
            public void onResponse(@NonNull Call<AppResponse<Meal>> call, @NonNull retrofit2.Response<AppResponse<Meal>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallBack.onSuccessResult(response.body().meals);
                } else {
                    networkCallBack.onFailureResult("Failed to fetch random meal");
                }
            }

            @Override
<<<<<<< HEAD
            public void onFailure(@NonNull Call<AppResponse<Meal>> call, @NonNull Throwable throwable) {
=======
            public void onFailure(Call<AppResponse<Meal>> call, Throwable throwable) {
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
    public void makeNetworkCallMealByName(String name, NetworkCallBack<Meal> networkCallBack) {
<<<<<<< HEAD
        mealService.getMealByName(name).enqueue(new Callback<AppResponse<Meal>>() {
=======
        mealService.getFoodByName(name).enqueue(new Callback<AppResponse<Meal>>() {
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a

            @Override
            public void onResponse(@NonNull Call<AppResponse<Meal>> call, @NonNull retrofit2.Response<AppResponse<Meal>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallBack.onSuccessResult(response.body().meals);
                } else {
                    networkCallBack.onFailureResult("Failed to fetch random meal");
                }
            }

            @Override
<<<<<<< HEAD
            public void onFailure(@NonNull Call<AppResponse<Meal>> call, @NonNull Throwable throwable) {
=======
            public void onFailure(Call<AppResponse<Meal>> call, Throwable throwable) {
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
    public void makeNetworkCallIngradiant(String ingrediant, NetworkCallBack<Meal> networkCallBack) {
        mealService.getMealByIngredient(ingrediant).enqueue(new Callback<AppResponse<Meal>>() {

            @Override
            public void onResponse(@NonNull Call<AppResponse<Meal>> call, @NonNull retrofit2.Response<AppResponse<Meal>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallBack.onSuccessResult(response.body().meals);
                } else {
                    networkCallBack.onFailureResult("Failed to fetch random meal");
                }
            }

            @Override
<<<<<<< HEAD
            public void onFailure(@NonNull Call<AppResponse<Meal>> call, @NonNull Throwable throwable) {
=======
            public void onFailure(Call<AppResponse<Meal>> call, Throwable throwable) {
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
<<<<<<< HEAD
    public void makeNetworkCallMealById(String id, NetworkCallBack<Meal> networkCallBack) {
=======
    public void makeNetworkCallFoodById(String id, NetworkCallBack<Meal> networkCallBack) {
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
        mealService.getMealById(id).enqueue(new Callback<AppResponse<Meal>>() {

            @Override
            public void onResponse(@NonNull Call<AppResponse<Meal>> call, @NonNull retrofit2.Response<AppResponse<Meal>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallBack.onSuccessResult(response.body().meals);
                } else {
                    networkCallBack.onFailureResult("Failed to fetch random meal");
                }
            }
<<<<<<< HEAD
            @Override
            public void onFailure(@NonNull Call<AppResponse<Meal>> call, @NonNull Throwable throwable) {
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
    public void makeNetworkCallFlagCountries(NetworkCallBack<Country> networkCallBack) {
        mealService.getCountries().enqueue(new Callback<AppResponse<Country>>() {

            @Override
            public void onResponse(@NonNull Call<AppResponse<Country>> call, @NonNull retrofit2.Response<AppResponse<Country>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkCallBack.onSuccessResult(response.body().meals);
                } else {
                    networkCallBack.onFailureResult("Failed to fetch random meal");
                }
            }

            @Override
            public void onFailure(@NonNull Call<AppResponse<Country>> call, @NonNull Throwable throwable) {
=======

            @Override
            public void onFailure(Call<AppResponse<Meal>> call, Throwable throwable) {
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });
    }
}
