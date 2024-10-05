package com.example.yumyay_chef.model.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yumyay_chef.AppNavigationActivity;
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.mealsDetails.view.MealContentFragment;
import com.example.yumyay_chef.model.Converter;
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealPlan;

import java.util.List;

public class CalenderAdapter extends RecyclerView.Adapter<CalenderAdapter.ViewHolder>{
    private final Context context;
    private final OnCalenderClickListener listener;
    private List<MealPlan> values;
    private static final String TAG = "PlannedAdapter";

    public CalenderAdapter(Context context, List<MealPlan> values, OnCalenderClickListener listener) {
        this.context = context;
        this.listener = listener;
        this.values = values;
    }

    public void setList(List<MealPlan> updatedProducts) {
        this.values = updatedProducts;
    }

    @NonNull
    @Override
    public CalenderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.calendermealrow, recyclerView, false);
        CalenderAdapter.ViewHolder vh = new CalenderAdapter.ViewHolder(v);
        Log.i(TAG, "===== ViewHolder Created ====");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CalenderAdapter.ViewHolder holder, int position) {
        MealPlan mealPlan =values.get(position);

        Glide.with(context).load(mealPlan.getMealThumbnail())
                .apply(new RequestOptions().override(200, 200)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.imageView);
        holder.txtTitle.setText(mealPlan.getMealName());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Meal meal1 = Converter.convertToMealClass(mealPlan);
                MealContentFragment mealFragment= MealContentFragment.getCurrentMeal(meal1);

                ((AppNavigationActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,mealFragment)
                        .addToBackStack(null).commit();
            }
            });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Meal meal1 = Converter.convertToMealClass(mealPlan);
                MealContentFragment mealFragment=MealContentFragment.getCurrentMeal(meal1);

                ((AppNavigationActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,mealFragment)
                        .addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return values.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView txtTitle;
        private Button btnRemoveFromFav;
        private View layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView;
            txtTitle=itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imgbtn);
            btnRemoveFromFav=itemView.findViewById(R.id.btnRemove);
        }
    }
}
