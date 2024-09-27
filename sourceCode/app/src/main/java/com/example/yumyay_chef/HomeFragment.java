package com.example.yumyay_chef;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yumyay_chef.homepage.homepagepresenter.HomePagePresenter;
import com.example.yumyay_chef.homepage.homepagepresenter.HomePagePresenterImpl;
import com.example.yumyay_chef.homepage.homepageview.HomePageActivityView;
import com.example.yumyay_chef.homepage.homepageview.HomePageAdapterCategory;
import com.example.yumyay_chef.homepage.homepageview.HomePageAdapter;
import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements HomePageActivityView {

    public static final String TAG = "HomeActivity";
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private HomePageAdapter homePageAdapter;
    private HomePageAdapterCategory homePageAdapterCategory;
    HomePagePresenter homePagePresenter;
    LinearLayoutManager linearLayout;
    LinearLayoutManager linearLayout2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);
        recyclerView.setHasFixedSize(true);
        linearLayout = new LinearLayoutManager(getActivity());
        homePageAdapter = new HomePageAdapter(getActivity(),new ArrayList<>());
        homePagePresenter = new HomePagePresenterImpl(this, MealsRepositoryImpl.getInstance(MealRemoteDataSourceImpl.getInstance()));
        linearLayout.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(homePageAdapter);
        recyclerView2.setHasFixedSize(true);
        linearLayout2 = new LinearLayoutManager(getActivity());
        homePageAdapterCategory = new HomePageAdapterCategory(getActivity(),new ArrayList<>());
        linearLayout2.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView2.setLayoutManager(linearLayout2);
        recyclerView2.setAdapter(homePageAdapterCategory);

        homePagePresenter.getRandomMealHP();
        homePagePresenter.getCategoryMealHP();
        return  view;
    }

    private void initUI(View v){
        recyclerView = v.findViewById(R.id.recView);
        recyclerView2 = v.findViewById(R.id.recView2);
    }


    @Override
    public void showRandomMealData(List<Meal> meals) {
        homePageAdapter.setList(meals);
        homePageAdapter.notifyDataSetChanged();
    }

    @Override
    public void showRandomMealErrMsg(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(error).setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showCategoryData(List<Category> categories) {
        homePageAdapterCategory.setList(categories);
        homePageAdapterCategory.notifyDataSetChanged();
    }

    @Override
    public void showCategoryErrMsg(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(error).setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}