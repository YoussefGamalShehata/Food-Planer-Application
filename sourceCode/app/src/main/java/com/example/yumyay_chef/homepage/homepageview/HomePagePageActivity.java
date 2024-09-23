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
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;
import com.example.yumyay_chef.network.allresponses.Meal;

import java.util.ArrayList;
import java.util.List;

public class HomePagePageActivity extends AppCompatActivity implements HomePageActivityView {
    public static final String TAG = "HomeActivity";
    private RecyclerView recyclerView;
    private HomePageAdapter homePageAdapter;
    HomePagePresenter homePagePresenter;
    LinearLayoutManager linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        initUI();

        recyclerView.setHasFixedSize(true);
        linearLayout = new LinearLayoutManager(this);
        homePageAdapter = new HomePageAdapter(HomePagePageActivity.this,new ArrayList<>());
        homePagePresenter = new HomePagePresenterImpl(this, MealsRepositoryImpl.getInstance(MealRemoteDataSourceImpl.getInstance()));
        linearLayout.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(homePageAdapter);
        homePagePresenter.getRandomMealHP();
    }
    private void initUI(){
        recyclerView = findViewById(R.id.recView);
    }

    @Override
    public void showData(List<Meal> meals) {
        homePageAdapter.setList(meals);
        homePageAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrMsg(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(error).setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}