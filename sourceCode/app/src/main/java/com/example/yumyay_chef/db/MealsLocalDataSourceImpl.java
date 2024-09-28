package com.example.yumyay_chef.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.yumyay_chef.model.Meal;

import java.util.List;

public class MealsLocalDataSourceImpl implements MealsLocalDataSource{
    private MealsDAO dao;
    private static MealsLocalDataSourceImpl localSource =null;
    private LiveData<List<Meal>> storedMeals;
    private MealsLocalDataSourceImpl(Context context)
    {
        AppDataBase db = AppDataBase.getInstance(context.getApplicationContext());
        dao = db.getMealDAO();
        storedMeals = dao.getAllMeals();
    }
    public static MealsLocalDataSourceImpl getInstance(Context context)
    {
        if(localSource == null)
        {
            localSource = new MealsLocalDataSourceImpl(context);
        }
        return localSource;
    }
    @Override
    public void insertMeal(Meal meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertMeal(meal);
            }
        }).start();
    }

    @Override
    public void deleteMeal(Meal meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteMeal(meal);
            }
        }).start();
    }

    @Override
    public LiveData<List<Meal>> getAllStoredMeals() {
        return  storedMeals;
    }
}
