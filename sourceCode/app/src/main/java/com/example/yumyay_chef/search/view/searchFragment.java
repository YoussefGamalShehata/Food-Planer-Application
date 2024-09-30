package com.example.yumyay_chef.search.view;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.yumyay_chef.R;
import com.example.yumyay_chef.db.MealsLocalDataSourceImpl;
import com.example.yumyay_chef.mealsDetails.view.MealContentFragment;
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;
import com.example.yumyay_chef.search.presenter.SearchPresnter;
import com.example.yumyay_chef.search.presenter.SearchPresnterImpl;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class searchFragment extends Fragment implements find,OnSearchClickListner{

    private SearchAdapter serAdapter;
    private SearchPresnter searchPresenter;
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

        searchPresenter =new SearchPresnterImpl(this, MealsRepositoryImpl.getInstance(MealRemoteDataSourceImpl.getInstance() , MealsLocalDataSourceImpl.getInstance(getContext())));


        serAdapter=new SearchAdapter(getContext(),new ArrayList<Meal>(),this);
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
                    case 0: searchPresenter.getFoodName(searchView.getQuery().toString());
                        break;
                    case 1: searchPresenter.getFoodByCountry(searchView.getQuery().toString());
                        break;
                    case 2: searchPresenter.getFoodByCategory(searchView.getQuery().toString());
                        break;
                    case 3: searchPresenter.getFoodByIngredient(searchView.getQuery().toString());
                        break;
                }


                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return view;
    }

    @Override
    public void onMealClickListner(Meal meal) {
        searchPresenter.getFoodById(meal.getMealId());
    }

    @Override
    public void showData(List<Meal> food) {
        if(serAdapter.byId){
            MealContentFragment mealFragment=MealContentFragment.getCurrentMeal(food.get(0));
            FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container,mealFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            serAdapter.byId=false;
        }
        else {
            serAdapter.setList(food);
            serAdapter.notifyDataSetChanged();
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