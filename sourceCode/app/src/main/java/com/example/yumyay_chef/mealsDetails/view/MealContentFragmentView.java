package com.example.yumyay_chef.mealsDetails.view;


import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface MealContentFragmentView {
    public void showIngData(List<Meal> food);
    public void showIngErrMsg(String error);
}