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
import com.example.yumyay_chef.model.Category;

import java.util.List;

public class HomePageAdapterCategory extends RecyclerView.Adapter<HomePageAdapterCategory.ViewHolder>{

    private static final String TAG = "RecyclerView2";
    private final Context context;
    private List<Category> categoryList;
    public HomePageAdapterCategory(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    public void setList(List<Category> categoryList){
        this.categoryList = categoryList;
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
    public HomePageAdapterCategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.test2, recyclerView, false);
        HomePageAdapterCategory.ViewHolder vh = new HomePageAdapterCategory.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageAdapterCategory.ViewHolder holder, int position) {
        Glide.with(context).load(categoryList.get(position).getStrCategoryThumb())
                .apply(new RequestOptions().override(200,200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.img);
        holder.txtView.setText(categoryList.get(position).getStrCategory());
    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
