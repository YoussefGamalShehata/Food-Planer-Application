package com.example.yumyay_chef.search.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yumyay_chef.AppNavigationActivity;
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.mealsDetails.view.MealContentFragment;
import com.example.yumyay_chef.model.Meal;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    private static final String TAG = "SearchAdapter";
    private final Context context;
    private List<Meal> mealList;
    private final OnSearchClickListner listener;
    public boolean byId=false;

    public SearchAdapter(Context context, List<Meal> categories, OnSearchClickListner listener) {
        this.context = context;
        this.mealList = categories;
        this.listener = listener;
    }

    public void setList(List<Meal> categories){ this.mealList = categories; }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txtView;
        public ConstraintLayout constraintLayout;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            img = v.findViewById(R.id.img);
            txtView = v.findViewById(R.id.textView);
            constraintLayout = v.findViewById(R.id.main);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.search_meal_holder, recyclerView, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Meal food =mealList.get(position);
        Glide.with(context).load(food.getMealThumbnail())
                .apply(new RequestOptions().override(200, 200)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MealContentFragment allMealDetailsFragment = MealContentFragment.getCurrentMeal(mealList.get(position));

                ((AppNavigationActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,allMealDetailsFragment)
                        .addToBackStack(null).commit();
            }
        });
        holder.txtView.setText(food.getMealName());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMealClickListner(food);
                byId=true;
            }
        });
    }

    @Override
    public int getItemCount() {return mealList.size();}





}
