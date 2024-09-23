package com.example.yumyay_chef.homepage.homepageview;

import com.example.yumyay_chef.network.allresponses.Meal;

import java.util.List;

public interface HomePageActivityView {
    public void showData(List<Meal> meals);
    public void showErrMsg(String error);
}
