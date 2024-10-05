package com.example.yumyay_chef.favoritemeals.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yumyay_chef.R;
import com.example.yumyay_chef.db.MealsLocalDataSourceImpl;
import com.example.yumyay_chef.favoritemeals.presnter.FavoritePagePresenterImpl;
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;

import java.util.List;


public class FavoritePageFragment extends Fragment implements FavoritePageView,OnFavClickRemoveListener {

    private LiveData<List<Meal>> listLiveData;
    private RecyclerView recyclerView;
    private FavoritePageAdapter favoritePageAdapter;
    private FavoritePagePresenterImpl favoritePagePresenter;
    LinearLayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerView = view.findViewById(R.id.recView3);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        favoritePagePresenter = new FavoritePagePresenterImpl(this, MealsRepositoryImpl.getInstance(MealRemoteDataSourceImpl.getInstance() , MealsLocalDataSourceImpl.getInstance(getContext())));
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        listLiveData = favoritePagePresenter.loadFavMeals();

        favoritePageAdapter = new FavoritePageAdapter(getContext(), listLiveData.getValue(), this);
        recyclerView.setAdapter(favoritePageAdapter);

        listLiveData.observe(getViewLifecycleOwner(), new Observer<List<Meal>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(List<Meal> meals) {
                if (meals != null) {
                    showMeal(meals);
                }
                else {
                    showErrMsg("No Product Found");
                }
            }
        });
        return view;
    }


    @Override
    public void showMeal(List<Meal> meal) {
        favoritePageAdapter.setMeals(meal);
        favoritePageAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrMsg(String errorMsg) {
        Toast.makeText(getContext(),errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFavRemoveMealClick(Meal meal) {
        favoritePagePresenter.removeMeal(meal);
        Toast.makeText(getContext(),"Meal Removed", Toast.LENGTH_SHORT).show();
    }
}