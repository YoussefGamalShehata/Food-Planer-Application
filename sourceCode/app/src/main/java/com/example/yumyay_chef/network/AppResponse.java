package com.example.yumyay_chef.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppResponse<T> {
    public List<T> meals;
    public List<T> categories;
}
