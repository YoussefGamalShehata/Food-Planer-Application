package com.example.yumyay_chef.mealsDetails.view;//package com.example.flavor.mealsDetails.view;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.net.Uri;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;
//import com.example.flavor.HomeActivity;
//import com.example.flavor.R;
//import com.example.flavor.home.view.HomeAdapter;
//import com.example.flavor.model.Meal;
//
//import java.util.List;
//
//public class MealAdapter {
//    private static final String TAG = "MealAdapter";
//    private final Context context;
//    private Meal meal;
//    private OnClickAddToFavListener listener;
//
//    private static final String YOUTUBE_PREFIX = "https://www.youtube.com/";
//
//    private Meal meal;
//
//    private ImageView mealImage;
//    private TextView mealTitle;
//    private TextView mealDesc;
//    private WebView mealVideo;
//
//    public MealAdapter(Context context,Meal meal, OnClickAddToFavListener listener) {
//        this.context = context;
//        this.listener = listener;
//        this.meal = meal;
//    }
//
//
//    @SuppressLint("SetJavaScriptEnabled")
//    private void setupWebView() {
//        WebSettings webSettings = mealVideo.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        mealVideo.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return !(url.startsWith(YOUTUBE_PREFIX + "watch") || url.startsWith(YOUTUBE_PREFIX + "embed/"));
//            }
//        });
//
//        String youtubeEmbedUrl = "https://www.youtube.com/embed/" + getYoutubeVideoId(meal.getStrYoutube());
//        mealVideo.loadUrl(youtubeEmbedUrl);
//    }
//
//    private void loadImage() {
//        Glide.with(this)
//                .load(meal.getStrMealThumb())
//                .apply(new RequestOptions()
//                        .override(200, 200)
//                        .placeholder(R.drawable.ic_launcher_background)
//                        .error(R.drawable.ic_launcher_foreground))
//                .into(mealImage);
//    }
//
//    private void setMealDetails() {
//        mealTitle.setText(meal.getStrMeal());
//        mealDesc.setText(meal.getStrInstructions());
//    }
//
//
//    private String getYoutubeVideoId(String url) {
//        if (TextUtils.isEmpty(url)) return "";
//
//        Uri uri = Uri.parse(url);
//        String videoId = uri.getQueryParameter("v");
//
//        if (videoId == null) {
//            videoId = uri.getLastPathSegment();
//        }
//        return videoId != null ? videoId : "";
//    }
//
//
//
//
//
//}
//
