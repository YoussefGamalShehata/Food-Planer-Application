package com.example.yumyay_chef;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.yumyay_chef.favoritemeals.view.FavoritePageFragment;
import com.example.yumyay_chef.homepage.homepageview.HomePageFragment;

public class NetworkFragment extends Fragment {

    private Button btnGoToFav;
    private ImageButton imageButtonRefresh;

    public NetworkFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new NetworkFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_network, container, false);

        // Initialize buttons
        btnGoToFav = view.findViewById(R.id.btnGoToFav);
        imageButtonRefresh = view.findViewById(R.id.imageButton);

        // Handle Go to Favorites Button click
        btnGoToFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to FavoriteFragment
                navigateToFragment(new FavoritePageFragment());
            }
        });

        // Handle Refresh ImageButton click
        imageButtonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check internet connection and navigate to HomeFragment if connected
                if (isNetworkAvailable(getContext())) {
                    navigateToFragment(new HomePageFragment());
                } else {
                    Toast.makeText(getContext(), "No internet connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    // Method to check if network is available
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    // Method to navigate to a fragment
    private void navigateToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);  // Assuming you have a FrameLayout with id fragment_container
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
