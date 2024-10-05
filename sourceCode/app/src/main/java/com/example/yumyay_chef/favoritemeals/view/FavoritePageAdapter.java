package com.example.yumyay_chef.favoritemeals.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yumyay_chef.AppNavigationActivity;
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.mealsDetails.view.MealContentFragment;
import com.example.yumyay_chef.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class FavoritePageAdapter extends RecyclerView.Adapter<FavoritePageAdapter.ViewHolder>{

    private final Context context;
    private List<Meal> meals;
    private static final String TAG = "FavMealsAdapter";
    private OnFavClickRemoveListener listener;


    public FavoritePageAdapter(Context _context, List<Meal> myDataset, OnFavClickRemoveListener listener) {
        this.context = _context;
        this.meals = myDataset != null ? myDataset : new ArrayList<>();
        this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView titleTxtView;
        public ImageButton imageButton2;
        public ConstraintLayout constraintLayout;
        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            img = v.findViewById(R.id.img);
            titleTxtView = v.findViewById(R.id.textView);
            imageButton2 = v.findViewById(R.id.imageButton2);
            constraintLayout = v.findViewById(R.id.main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.fav_row, recyclerView, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Meal meal = meals.get(position);
        Glide.with(context).load(meal.getMealThumbnail())
                .apply(new RequestOptions().override(200, 200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MealContentFragment allMealContentFragment = MealContentFragment.getCurrentMeal(meal);

                ((AppNavigationActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, allMealContentFragment)
                        .addToBackStack(null).commit();
            }
        });
        holder.titleTxtView.setText(meal.getMealName());
        holder.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFavRemoveMealClick(meal);
            }
        });
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, meal.getMealName(), Toast.LENGTH_SHORT).show();
            }
        });
        Log.i(TAG, "***** onBindViewHolder **************");
    }


    @Override
    public int getItemCount() {
        return meals.size();
    }

    public void setMeals(List<Meal> meal) {
        this.meals = meal != null ? meal : new ArrayList<>();
        notifyDataSetChanged();
    }
}
