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
<<<<<<< HEAD
import com.bumptech.glide.load.engine.DiskCacheStrategy;
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
import com.bumptech.glide.request.RequestOptions;
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.model.Category;

import java.util.List;

public class HomePageCategoryAdapter extends RecyclerView.Adapter<HomePageCategoryAdapter.ViewHolder>{

    private static final String TAG = "RecyclerView2";
    private final Context context;
    private List<Category> categoryList;
    public  static String id = "Beef";
    HomePageCategoryDetailsAdapter homePageCategoryDetailsAdapter;
    public interface OnCategoryClickListener {
        void onCategoryClick(String categoryId);
    }

    private OnCategoryClickListener listener;

    public void setOnCategoryClickListener(OnCategoryClickListener listener) {
        this.listener = listener;
    }
    public HomePageCategoryAdapter(Context context, List<Category> categoryList) {
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
    public HomePageCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
<<<<<<< HEAD
        View v = inflater.inflate(R.layout.categoryrow, recyclerView, false);
=======
        View v = inflater.inflate(R.layout.test2, recyclerView, false);
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
        HomePageCategoryAdapter.ViewHolder vh = new HomePageCategoryAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageCategoryAdapter.ViewHolder holder, int position) {
<<<<<<< HEAD
        Glide.with(context)
                .load(categoryList.get(position).getStrCategoryThumb())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.loading) // Use loading.gif as the placeholder
                        .error(R.drawable.ic_launcher_foreground) // Error image if loading fails
                        .centerCrop() // Use centerCrop to fill the ImageView while maintaining aspect ratio
                        .diskCacheStrategy(DiskCacheStrategy.ALL) // Cache all versions of the image
                )
                .into(holder.img);


=======
        Glide.with(context).load(categoryList.get(position).getStrCategoryThumb())
                .apply(new RequestOptions().override(200,200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.img);
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
        holder.txtView.setText(categoryList.get(position).getStrCategory());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String categoryId = categoryList.get(position).getStrCategory();
                HomePageCategoryAdapter.id = categoryId;

                // Notify the listener (HomeFragment)
                if (listener != null) {
                    listener.onCategoryClick(categoryId);
                }
<<<<<<< HEAD
                Toast.makeText(view.getContext(), categoryList.get(position).getStrCategory() + " Available", Toast.LENGTH_SHORT).show();
=======
                Toast.makeText(view.getContext(), "Hi from button" + " added to cart", Toast.LENGTH_SHORT).show();
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
            }
        });
    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
