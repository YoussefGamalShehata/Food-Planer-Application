package com.example.yumyay_chef.homepage.homepageview;

import android.annotation.SuppressLint;
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

import com.example.yumyay_chef.R;
import com.example.yumyay_chef.model.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private static final String TAG = "RecyclerView2";
    private final Context context;
    private List<Country> countries;
    private int id;
    public static String name = "American";
    public interface OnCountryClickListener {
        void onCountryClick(String categoryId);
    }
    private CountryAdapter.OnCountryClickListener listener;

    public void setOnCountryClickListener(CountryAdapter.OnCountryClickListener listener) {
        this.listener = listener;
    }
    public CountryAdapter(Context context, List<Country> countries) {
        this.context = context;
        this.countries = countries;
    }

    public void setList(List<Country> countries){
        this.countries = countries;
        countries.removeIf(country -> "Unknown".equals(country.getStrArea()));
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txtView;
        public ConstraintLayout constraintLayout;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            img = v.findViewById(R.id.flagImageView);
            txtView = v.findViewById(R.id.countryNameTextView);
            constraintLayout = v.findViewById(R.id.main);
        }
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.flags_row, recyclerView, false);
        CountryAdapter.ViewHolder vh = new CountryAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        id =context.getResources().getIdentifier(countries.get(position).getStrArea().toLowerCase(), "drawable", context.getPackageName());
        holder.img.setImageResource(id);
        holder.txtView.setText(countries.get(position).getStrArea());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countryId = countries.get(position).getStrArea();
                CountryAdapter.name = countryId;
                if (listener != null) {
                    listener.onCountryClick(countryId);
                }
                Toast.makeText(view.getContext(), "Hi from button" + " added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return countries.size();
    }
}
