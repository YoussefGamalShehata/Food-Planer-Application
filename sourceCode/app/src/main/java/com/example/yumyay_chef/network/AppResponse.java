package com.example.yumyay_chef.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppResponse<T> {
    @SerializedName("meals")
    public List<T> meals;
    @SerializedName("categories")
    public List<T> categories;
}
