package com.example.yumyay_chef.homepage.homepageview;

import com.example.yumyay_chef.model.Meal;

public interface HomePageClickListener {
    void onCountryClick(String selectedCountry);
    void onMealClick(String id);
}
