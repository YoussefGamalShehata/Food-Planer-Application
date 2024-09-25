package com.example.yumyay_chef.network;

import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface NetworkCallBackForCategory {
    public void onSuccessCategoryResult(List<Category> categoryList);
    public void onFailureCategoryResult(String errorMsg);
}
