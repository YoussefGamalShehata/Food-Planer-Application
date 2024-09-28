package com.example.yumyay_chef.mealsDetails.view;


import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.db.MealsLocalDataSourceImpl;
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;

public class MealContentFragment extends Fragment {

    private static final String MEAL_KEY = "MEAL_KEY";
    private static final String YOUTUBE_PREFIX = "https://www.youtube.com/";

    private Meal meal;

    private ImageView mealImage;
    private TextView mealTitle;
    private TextView mealDesc;
    private WebView mealVideo;
    private Button addBtn;

    private MealsRepositoryImpl _repo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            meal = (Meal) getArguments().getSerializable(MEAL_KEY);
            _repo = MealsRepositoryImpl.getInstance(MealRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(getContext()));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_content, container, false);

        mealImage = view.findViewById(R.id.mealImg);
        mealTitle = view.findViewById(R.id.txtName);
        mealDesc = view.findViewById(R.id.txtInstruction);
        mealVideo = view.findViewById(R.id.webViedo);
        addBtn = view.findViewById(R.id.btnAddFav);

        setupWebView();
        loadImage();
        setMealDetails();

        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView() {
        WebSettings webSettings = mealVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mealVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return !(url.startsWith(YOUTUBE_PREFIX + "watch") || url.startsWith(YOUTUBE_PREFIX + "embed/"));
            }
        });

        String youtubeEmbedUrl = "https://www.youtube.com/embed/" + getYoutubeVideoId(meal.getYoutubeUrl());
        mealVideo.loadUrl(youtubeEmbedUrl);
    }

    private void loadImage() {
        Glide.with(this)
                .load(meal.getMealThumbnail())
                .apply(new RequestOptions()
                        .override(200, 200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(mealImage);
    }

    private void setMealDetails() {
        mealTitle.setText(meal.getMealName());
        mealDesc.setText(meal.getInstructions());
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"add to fav btn",Toast.LENGTH_SHORT).show();
                addToFavMeals(meal);
                }
            });
    }

    public static MealContentFragment getCurrentMeal(Meal meal) {
        MealContentFragment fragment = new MealContentFragment();
        Bundle args = new Bundle();
        args.putSerializable(MEAL_KEY, meal);
        fragment.setArguments(args);
        return fragment;
    }

    private String getYoutubeVideoId(String url) {
        if (TextUtils.isEmpty(url)) return "";

        Uri uri = Uri.parse(url);
        String videoId = uri.getQueryParameter("v");

        if (videoId == null) {
            videoId = uri.getLastPathSegment();
        }
        return videoId != null ? videoId : "";
    }

    public void addToFavMeals(Meal meal) {
        _repo.insertMeal(meal);
    }
}