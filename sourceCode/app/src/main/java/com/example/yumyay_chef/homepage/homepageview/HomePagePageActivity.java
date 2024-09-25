package com.example.yumyay_chef.homepage.homepageview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yumyay_chef.R;
import com.example.yumyay_chef.homepage.homepagepresenter.HomePagePresenter;
import com.example.yumyay_chef.homepage.homepagepresenter.HomePagePresenterImpl;
import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;
import com.example.yumyay_chef.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class HomePagePageActivity extends AppCompatActivity implements HomePageActivityRandomMealsView ,HomaPageActivityCategoryMealsView{
    public static final String TAG = "HomeActivity";
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private HomePageAdapterRandomMeals homePageAdapterRandomMeals;
    private HomePageAdapterCategory homePageAdapterCategory;
    HomePagePresenter homePagePresenter;
    LinearLayoutManager linearLayout;
    LinearLayoutManager linearLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        initUI();

        recyclerView.setHasFixedSize(true);
        linearLayout = new LinearLayoutManager(this);
        homePageAdapterRandomMeals = new HomePageAdapterRandomMeals(HomePagePageActivity.this,new ArrayList<>());
        homePagePresenter = new HomePagePresenterImpl(this,this ,MealsRepositoryImpl.getInstance(MealRemoteDataSourceImpl.getInstance()));
        linearLayout.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(homePageAdapterRandomMeals);

        recyclerView2.setHasFixedSize(true);
        linearLayout2 = new LinearLayoutManager(this);
        homePageAdapterCategory = new HomePageAdapterCategory(HomePagePageActivity.this,new ArrayList<>());
        linearLayout2.setOrientation(RecyclerView.VERTICAL);
        recyclerView2.setLayoutManager(linearLayout2);
        recyclerView2.setAdapter(homePageAdapterCategory);



        homePagePresenter.getRandomMealHP();
        homePagePresenter.getCategoryMealHP();

    }
    private void initUI(){
        recyclerView = findViewById(R.id.recView);
        recyclerView2 = findViewById((R.id.recView2));
    }


    @Override
    public void showRandomMealData(List<Meal> meals) {
        homePageAdapterRandomMeals.setList(meals);
        homePageAdapterRandomMeals.notifyDataSetChanged();
    }

    @Override
    public void showRandomMealErrMsg(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(error).setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showCategoryData(List<Category> meals) {
        homePageAdapterCategory.setList(meals);
        homePageAdapterCategory.notifyDataSetChanged();
    }

    @Override
    public void showCategoryErrMsg(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(error).setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}