package com.example.yumyay_chef.mealsDetails.view;

import com.example.yumyay_chef.model.Meal;

public interface OnClickAddToFavListener {
    void onLayoutClick(Meal meal);
    void onAddToFavClick(Meal meal);
    void onCheckClick(Meal meal);
    void onRemoveFavClick(Meal meal);
}
