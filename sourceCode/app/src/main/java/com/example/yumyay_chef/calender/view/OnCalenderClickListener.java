package com.example.yumyay_chef.calender.view;

import com.example.yumyay_chef.model.MealPlan;

public interface OnCalenderClickListener {
    void onLayoutClick(MealPlan mealPlan);
    void onRemoveClick(MealPlan mealPlan);
}
