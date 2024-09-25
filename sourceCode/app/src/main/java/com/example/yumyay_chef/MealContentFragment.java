package com.example.yumyay_chef;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yumyay_chef.model.Meal;

public class MealContentFragment extends Fragment {
    private static final String ARG_MEAL_NAME = "meal_name";
    private Meal meal;

    ImageView mealImage;
    TextView mealName;
    TextView instruction;
    WebView webView;
    ProgressBar progressBar;
    private FrameLayout fullscreenContainer;
    private WebView fullscreenWebView;
    private View currentView; // To keep track of the current view
    private Button exitFullscreenButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            meal = (Meal)getArguments().getSerializable(ARG_MEAL_NAME);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_content, container, false);

        // Initialize UI
        progressBar = view.findViewById(R.id.progressBar);
        mealImage = view.findViewById(R.id.mealImg);
        mealName = view.findViewById(R.id.txtName);
        instruction = view.findViewById(R.id.txtInstruction);

        // Initialize WebView
        webView = view.findViewById(R.id.webViedo);
        fullscreenContainer = view.findViewById(R.id.fullscreen_container);
        fullscreenWebView = view.findViewById(R.id.fullscreen_webview);
        exitFullscreenButton = view.findViewById(R.id.exit_fullscreen);

        exitFullscreenButton.setOnClickListener(v -> exitFullscreen());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set WebViewClient with ProgressBar and error handling
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
                webView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
                webView.animate().alpha(1.0f).setDuration(300);  // Add a fade-in animation
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Failed to load video", Toast.LENGTH_SHORT).show();
            }
        });
        // Set WebChromeClient for handling full-screen videos
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                currentView = view;
                fullscreenContainer.setVisibility(View.VISIBLE);
                fullscreenWebView.loadUrl("about:blank"); // Clear any previous URL
                fullscreenWebView.addView(view, new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT));
            }

            @Override
            public void onHideCustomView() {
                exitFullscreen();
            }

        });


        // Load meal image and text content
        Glide.with(this)
                .load(meal.getMealThumbnail())
                .apply(new RequestOptions().override(200, 200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(mealImage);

        // Format instructions
        String[] paragraphs = meal.getInstructions().split("\\.");
        StringBuilder formattedText = new StringBuilder();
        for (int i = 0; i < paragraphs.length; i++) {
            if (!paragraphs[i].trim().isEmpty()) {
                formattedText.append((i + 1) + "- " + paragraphs[i].trim() + "\n\n");
            }
        }
        mealName.setText(meal.getMealName());
        instruction.setText(formattedText.toString().trim());

        // Load YouTube video
        String youtubeEmbedUrl = "https://www.youtube.com/embed/" + getYoutubeVideoId(meal.getYoutubeUrl());
        webView.loadUrl(youtubeEmbedUrl);

        return view;
    }

    private String getYoutubeVideoId(String url) {
        String videoId = "";
        if (url != null && url.contains("v=")) {
            String[] parts = url.split("v=");
            videoId = parts[1].split("&")[0];
        }
        return videoId;
    }

    public static MealContentFragment getInstance(Meal meal) {
        MealContentFragment myFragment = new MealContentFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_MEAL_NAME, meal);
        myFragment.setArguments(args);
        return myFragment;
    }
    private void exitFullscreen() {
        fullscreenContainer.setVisibility(View.GONE);
        if (currentView != null) {
            fullscreenWebView.removeView(currentView);
            currentView = null; // Clear reference to the current view
        }
    }
}
