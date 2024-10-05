package com.example.yumyay_chef.homepage.homepageview;

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
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
<<<<<<< HEAD
import com.bumptech.glide.request.target.Target;
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
import com.example.yumyay_chef.AppNavigationActivity;
import com.example.yumyay_chef.mealsDetails.view.MealContentFragment;
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.model.Meal;

import java.util.List;

public class HomePageRandomAdapter extends RecyclerView.Adapter<HomePageRandomAdapter.ViewHolder> {

    private static final String TAG = "RecyclerView";
    private final Context context;
    private List<Meal> values;

    public HomePageRandomAdapter(Context context, List<Meal> values) {
        this.context = context;
        this.values = values;
    }

    public void setList(List<Meal> meals){
        this.values = meals;
    }


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
    public HomePageRandomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.randomrow, recyclerView, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageRandomAdapter.ViewHolder holder, int position) {
        Meal meal = values.get(position);
<<<<<<< HEAD
        Glide.with(context)
                .load(values.get(position).getMealThumbnail())
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
=======
        Glide.with(context).load(values.get(position).getMealThumbnail())
                .apply(new RequestOptions().override(200,200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
                .into(holder.img);
        holder.txtView.setText(values.get(position).getMealName());
        holder.img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MealContentFragment mealFragment= MealContentFragment.getCurrentMeal(meal);

                ((AppNavigationActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,mealFragment)
                        .addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {return values.size();}
}
