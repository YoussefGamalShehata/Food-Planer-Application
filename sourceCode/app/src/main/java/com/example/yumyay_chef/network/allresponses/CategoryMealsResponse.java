package com.example.yumyay_chef.network.allresponses;

import com.example.yumyay_chef.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMealsResponse {
    public List<Category> categoryList;

    public CategoryMealsResponse(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Category> getCategories() {
        return categoryList;
    }

    public void setCategories(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
