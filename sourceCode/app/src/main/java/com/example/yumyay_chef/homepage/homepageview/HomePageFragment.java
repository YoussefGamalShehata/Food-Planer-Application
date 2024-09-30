package com.example.yumyay_chef.homepage.homepageview;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yumyay_chef.R;
import com.example.yumyay_chef.db.MealsLocalDataSourceImpl;
import com.example.yumyay_chef.homepage.homepagepresenter.HomePagePresenter;
import com.example.yumyay_chef.homepage.homepagepresenter.HomePagePresenterImpl;
import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;

import java.util.ArrayList;
import java.util.List;


public class HomePageFragment extends Fragment implements HomePageFragmentView,HomePageCategoryAdapter.OnCategoryClickListener {

    public static final String TAG = "HomeActivity";
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private HomePageRandomAdapter homePageRandomAdapter;
    private HomePageCategoryAdapter homePageCategoryAdapter;
    private HomePageCategoryDetailsAdapter homePageCategoryDetailsAdapter;
    HomePagePresenter homePagePresenter;
    LinearLayoutManager linearLayout;
    LinearLayoutManager linearLayout2;
    LinearLayoutManager  linearLayout3;
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
        homePageRandomAdapter = new HomePageRandomAdapter(getActivity(),new ArrayList<>());
        homePagePresenter = new HomePagePresenterImpl(this, MealsRepositoryImpl.getInstance(MealRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(getContext())));
        linearLayout.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(homePageRandomAdapter);

        recyclerView2.setHasFixedSize(true);
        linearLayout2 = new LinearLayoutManager(getActivity());
        homePageCategoryAdapter = new HomePageCategoryAdapter(getActivity(),new ArrayList<>());
        linearLayout2.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView2.setLayoutManager(linearLayout2);
        recyclerView2.setAdapter(homePageCategoryAdapter);

        homePageCategoryAdapter.setOnCategoryClickListener(this);
        recyclerView3.setHasFixedSize(true);
        linearLayout3 = new LinearLayoutManager(getActivity());
        homePageCategoryDetailsAdapter = new HomePageCategoryDetailsAdapter(getActivity(),new ArrayList<>());
        linearLayout3.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView3.setLayoutManager(linearLayout3);
        recyclerView3.setAdapter(homePageCategoryDetailsAdapter);

        homePagePresenter.getRandomMealHP();
        homePagePresenter.getCategoryMealHP();
        homePagePresenter.getMealsByCategoryHP(HomePageCategoryAdapter.id);
        return  view;
    }
    private void initUI(View v){
        recyclerView = v.findViewById(R.id.recView);
        recyclerView2 = v.findViewById(R.id.recView2);
        recyclerView3=v.findViewById(R.id.recView3);
    }
    @Override
    public void showRandomMealData(List<Meal> meals) {
        homePageRandomAdapter.setList(meals);
        homePageRandomAdapter.notifyDataSetChanged();
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
            homePageCategoryAdapter.setList(categories);
            homePageCategoryAdapter.notifyDataSetChanged();
        }
        @Override
        public void showCategoryErrMsg(String error) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(error).setTitle("An Error Occurred");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        @Override
        public void showCategoryMeal(List<Meal> meal) {
            homePageCategoryDetailsAdapter.setList(meal);
            homePageCategoryDetailsAdapter.notifyDataSetChanged();
        }
        @Override
        public void showCategoryMealErrMsg(String error) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(error).setTitle("An Error Occurred");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        @Override
        public void onCategoryClick(String categoryId) {
            homePagePresenter.getMealsByCategoryHP(categoryId);
    }
}