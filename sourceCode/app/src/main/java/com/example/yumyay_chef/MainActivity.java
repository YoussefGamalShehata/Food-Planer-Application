package com.example.yumyay_chef;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yumyay_chef.homepage.homepageview.HomePagePageActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Intent outIntent = new Intent(MainActivity.this, HomePagePageActivity.class);
        startActivity(outIntent);
    }
}