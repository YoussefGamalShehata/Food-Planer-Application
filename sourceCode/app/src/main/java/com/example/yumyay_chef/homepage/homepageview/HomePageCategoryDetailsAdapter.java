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
import com.bumptech.glide.request.RequestOptions;
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.model.Meal;
import java.util.List;

public class HomePageCategoryDetailsAdapter extends RecyclerView.Adapter<HomePageCategoryDetailsAdapter.ViewHolder>{
    private static final String TAG = "RecyclerView2";
    private final Context context;
    private List<Meal> allcategoryList;
<<<<<<< HEAD
    HomePageClickListener listener;
    public HomePageCategoryDetailsAdapter(Context context, List<Meal> categoryList, HomePageClickListener listener) {
        this.context = context;
        this.allcategoryList = categoryList;
        this.listener = listener;
=======
    public HomePageCategoryDetailsAdapter(Context context, List<Meal> categoryList) {
        this.context = context;
        this.allcategoryList = categoryList;
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
    }
    public void setList(List<Meal> categoryList){
        this.allcategoryList = categoryList;
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
    public HomePageCategoryDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
<<<<<<< HEAD
        View v = inflater.inflate(R.layout.meal_row_by_category, recyclerView, false);
=======
        View v = inflater.inflate(R.layout.test2, recyclerView, false);
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
        HomePageCategoryDetailsAdapter.ViewHolder vh = new HomePageCategoryDetailsAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull HomePageCategoryDetailsAdapter.ViewHolder holder, int position) {
<<<<<<< HEAD
        Meal meal = allcategoryList.get(position);
        Glide.with(context).load(allcategoryList.get(position).getMealThumbnail())
                .apply(new RequestOptions().override(200,200)
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.img);
        holder.txtView.setText(meal.getMealName());
        holder.img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                listener.onMealClick(meal.getMealId());
            }
        });
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMealClick(meal.getMealId());
            }
        });
=======
        Glide.with(context).load(allcategoryList.get(position).getMealThumbnail())
                .apply(new RequestOptions().override(200,200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.img);
        holder.txtView.setText(allcategoryList.get(position).getMealName());
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
    }
    @Override
    public int getItemCount() {
        return allcategoryList.size();
    }
}
