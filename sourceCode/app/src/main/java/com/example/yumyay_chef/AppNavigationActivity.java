package com.example.yumyay_chef;

import android.os.Bundle;
<<<<<<< HEAD

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.yumyay_chef.model.view.CalenderFragment;
import com.example.yumyay_chef.favoritemeals.view.FavoritePageFragment;
import com.example.yumyay_chef.homepage.homepageview.HomePageFragment;
import com.example.yumyay_chef.search.view.SearchFragment;
=======
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.yumyay_chef.favoritemeals.view.FavoritePageFragment;
import com.example.yumyay_chef.homepage.homepageview.HomePageFragment;
import com.example.yumyay_chef.search.view.searchFragment;
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
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
<<<<<<< HEAD
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

=======
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment currentFrag = null;
                int Item = item.getItemId();
                if (Item==R.id.page_1)
                {
                    currentFrag=new HomePageFragment();
                }
                else if (Item==R.id.page_2){
                    currentFrag=new searchFragment();
                }
                else if (Item==R.id.page_3){
                    currentFrag=new FavoritePageFragment();
                }
                else if (Item==R.id.page_4){
                    currentFrag=new CalenderFragment();
                }

                if (currentFrag != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFrag).commit();
                }
                return true;
            }
        });
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a

    }



}