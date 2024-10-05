package com.example.yumyay_chef.calender.view;

import com.example.yumyay_chef.model.MealPlan;

import java.util.List;

public interface CalenderView {
    public void showData(List<MealPlan> mealPlans);
    public void showErrMsg(String error);
}
