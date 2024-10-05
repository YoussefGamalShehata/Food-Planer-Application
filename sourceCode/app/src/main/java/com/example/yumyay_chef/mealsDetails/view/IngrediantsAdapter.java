package com.example.yumyay_chef.mealsDetails.view;

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
import com.example.yumyay_chef.model.Ingrediant;

import java.util.List;

public class IngrediantsAdapter extends RecyclerView.Adapter<IngrediantsAdapter.ViewHolder>  {
    private static final String TAG = "RecyclerView";
    private final Context context;
    private List<Ingrediant> values;

    String imageUrl;
    OnClickAddToFavListener favListener ;
    public IngrediantsAdapter(Context context,List<Ingrediant>values,OnClickAddToFavListener favListener) {
        this.context = context;
        this.values=values;
        this.favListener = favListener;
    }
    public void setList2( List<Ingrediant> meal) {
        Log.i(TAG, "setList2: "+ meal);
        this.values = meal;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txtView;
        private TextView txtView10;
        public ConstraintLayout constraintLayout;
        public View layout;


        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            img = v.findViewById(R.id.imgbtn);
            txtView = v.findViewById(R.id.textView);
            txtView10=v.findViewById(R.id.textView10);
            constraintLayout = v.findViewById(R.id.ingredientRow);
        }
    }

    @NonNull
    @Override
    public IngrediantsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.ingredientsrow, recyclerView, false);
        IngrediantsAdapter.ViewHolder vh = new IngrediantsAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull IngrediantsAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(values.get(position).getIngredientThumb())
                .apply(new RequestOptions().override(200, 200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.img);
        holder.txtView.setText(values.get(position).getIngredientName());
        holder.txtView10.setText(values.get(position).getIngredientMeasure());
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
