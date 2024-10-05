package com.example.yumyay_chef.homepage.homepageview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.model.Meal;

import java.util.List;

public class CountryDetalisAdapter extends RecyclerView.Adapter<CountryDetalisAdapter.ViewHolder> {
    private static final String TAG = "RecyclerView2";
    private final Context context;
    private List<Meal> meals;
    HomePageClickListener listener;
    public CountryDetalisAdapter(Context context, List<Meal> meals, HomePageClickListener listener) {
        this.context = context;
        this.meals = meals;
        this.listener = listener;
    }
    public void setList(List<Meal> categoryList){
        this.meals = categoryList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txtView;
        public ConstraintLayout constraintLayout;
        public View layout;
        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            img = v.findViewById(R.id.img);
            txtView = v.findViewById(R.id.textView);
            constraintLayout = v.findViewById(R.id.main);
        }
    }
    @NonNull
    @Override
    public CountryDetalisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.meals_row_by_country, recyclerView, false);
        CountryDetalisAdapter.ViewHolder vh = new CountryDetalisAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull CountryDetalisAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(meals.get(position).getMealThumbnail())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.loading) // Placeholder image while loading
                        .error(R.drawable.ic_launcher_foreground) // Error image if loading fails
                        .centerCrop() // Use centerCrop to fill the ImageView while maintaining aspect ratio
                        .diskCacheStrategy(DiskCacheStrategy.ALL) // Cache all versions of the image
                        .priority(Priority.HIGH) // Set a high priority for loading the image
                        .timeout(10000) // Set a timeout for image loading (10 seconds)
                        .dontAnimate() // Disable default animations for smoother performance
                        .override(Target.SIZE_ORIGINAL) // Use original size to avoid scaling issues
                        .fitCenter() // Scale down the image to fit the view, maintaining aspect ratio
                )
                .into(holder.img);
        holder.txtView.setText(meals.get(position).getMealName());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onMealClick(meals.get(position).getMealId());
                }
                Toast.makeText(view.getContext(), "Hi from button" + " added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return meals.size();
    }

}
