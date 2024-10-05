package com.example.yumyay_chef;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.yumyay_chef.model.view.CalenderFragment;
import com.example.yumyay_chef.favoritemeals.view.FavoritePageFragment;
import com.example.yumyay_chef.homepage.homepageview.HomePageFragment;
import com.example.yumyay_chef.search.view.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_navigation);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomePageFragment()).commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.page_1) {
                selectedFragment = new HomePageFragment();
            } else if (item.getItemId() == R.id.page_2) {
                selectedFragment = new SearchFragment();
            } else if (item.getItemId() == R.id.page_3) {
                selectedFragment = new FavoritePageFragment();
            } else if (item.getItemId() == R.id.page_4) {
                selectedFragment = new CalenderFragment();
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }
            return true;
        });


    }



}