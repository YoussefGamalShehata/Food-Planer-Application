package com.example.yumyay_chef.search.view;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.yumyay_chef.NetworkFragment;
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.db.MealsLocalDataSourceImpl;
import com.example.yumyay_chef.mealsDetails.view.MealContentFragment;
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;
import com.example.yumyay_chef.search.presenter.SearchPresenter;
import com.example.yumyay_chef.search.presenter.SearchPresenterImpl;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment implements SearchFragmentView, OnSearchFragmentClickListener {
    private boolean hasShownNoMealsToast = false;
    private SearchFragmentAdapter serAdapter;
    private SearchPresenter searchPresenter;
    private RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    int tap=0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);


        recyclerView=view.findViewById(R.id.recView);
        TabLayout tableLayout=view.findViewById(R.id.tabLayout);
        SearchView searchView=view.findViewById(R.id.searchView);
        if (!NetworkFragment.isNetworkAvailable(getContext())) {
            // Redirect to NetworkFragment when there is no network connection
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, NetworkFragment.newInstance());
            transaction.addToBackStack(null);
            transaction.commit();
            return view;  // Return early to avoid fetching data
        }
        searchPresenter =new SearchPresenterImpl(this, MealsRepositoryImpl.getInstance(MealRemoteDataSourceImpl.getInstance() , MealsLocalDataSourceImpl.getInstance(getContext())));
        serAdapter=new SearchFragmentAdapter(getContext(),new ArrayList<Meal>(),this);
        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(serAdapter);

        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tap=tab.getPosition();

                switch (tap){
                    case 0: searchView.setQueryHint("Please Enter Meal name");
                        break;
                    case 1: searchView.setQueryHint("Please Enter Country name");
                        break;
                    case 2: searchView.setQueryHint("Please Enter Category name");
                        break;
                    case 3: searchView.setQueryHint("Please Enter Ingretient name");
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                switch (tap){
                    case 0: searchPresenter.getMealName(searchView.getQuery().toString());
                        break;
                    case 1: searchPresenter.getMealByCountry(searchView.getQuery().toString());
                        break;
                    case 2: searchPresenter.getMealByCategory(searchView.getQuery().toString());
                        break;
                    case 3: searchPresenter.getMealByIngredient(searchView.getQuery().toString());
                        break;
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                switch (tap)
                {
                    case 0: searchPresenter.getMealName(searchView.getQuery().toString());
                        break;
                    case 1: searchPresenter.getMealByCountry(searchView.getQuery().toString());
                        break;
                    case 2: searchPresenter.getMealByCategory(searchView.getQuery().toString());
                        break;
                    case 3: searchPresenter.getMealByIngredient(searchView.getQuery().toString());
                        break;
                }
                return false;
            }
        });

        return view;
    }
    @Override
    public void onMealClickListener(Meal meal) {
        searchPresenter.getMealById(meal.getMealId());
    }
    @Override
    public void showData(List<Meal> meals) {
        if(serAdapter.byId){
            MealContentFragment mealFragment=MealContentFragment.getCurrentMeal(meals.get(0));
            FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container,mealFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            serAdapter.byId=false;

        }
        else {
            if (meals != null && !meals.isEmpty()) {
                serAdapter.setList(meals);
                serAdapter.notifyDataSetChanged();
                hasShownNoMealsToast = false;
            } else {
                if (!hasShownNoMealsToast) {
                    hasShownNoMealsToast = true;
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(), "No Meals Found", Toast.LENGTH_SHORT).show();
                        }
                    }, 3500);
                }
            }
        }
    }

    @Override
    public void showErrMsg(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(error).setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}