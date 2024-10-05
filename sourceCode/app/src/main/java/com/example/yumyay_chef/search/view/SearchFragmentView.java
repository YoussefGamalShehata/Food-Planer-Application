package com.example.yumyay_chef.search.view;

import com.example.yumyay_chef.model.Meal;

import java.util.List;

public interface SearchFragmentView {

    public void showData(List<Meal> food);
    public void showErrMsg(String error);
}
