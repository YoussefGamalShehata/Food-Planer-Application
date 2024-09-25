package com.example.yumyay_chef.homepage.homepageview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yumyay_chef.CalenderFragment;
import com.example.yumyay_chef.FavoriteFragment;
import com.example.yumyay_chef.HomeFragment;
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.SearchFragment;
import com.example.yumyay_chef.homepage.homepagepresenter.HomePagePresenter;
import com.example.yumyay_chef.homepage.homepagepresenter.HomePagePresenterImpl;
import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;
import com.example.yumyay_chef.model.Meal;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomePagePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_navigation);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int Item = item.getItemId();
                if (Item==R.id.page_1)
                {
                    selectedFragment=new HomeFragment();
                }
                else if (Item==R.id.page_2){
                    selectedFragment=new SearchFragment();
                }
                else if (Item==R.id.page_3){
                    selectedFragment=new FavoriteFragment();
                }
                else if (Item==R.id.page_4){
                    selectedFragment=new CalenderFragment();
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                }
                return true;
            }
        });

    }



}