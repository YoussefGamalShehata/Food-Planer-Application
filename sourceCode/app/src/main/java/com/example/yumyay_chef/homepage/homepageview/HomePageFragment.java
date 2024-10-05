package com.example.yumyay_chef.homepage.homepageview;

<<<<<<< HEAD
import android.annotation.SuppressLint;
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
<<<<<<< HEAD
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.yumyay_chef.NetworkFragment;
=======
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
import com.example.yumyay_chef.R;
import com.example.yumyay_chef.db.MealsLocalDataSourceImpl;
import com.example.yumyay_chef.homepage.homepagepresenter.HomePagePresenter;
import com.example.yumyay_chef.homepage.homepagepresenter.HomePagePresenterImpl;
<<<<<<< HEAD
import com.example.yumyay_chef.mealsDetails.view.MealContentFragment;
import com.example.yumyay_chef.model.Category;
import com.example.yumyay_chef.model.Country;
=======
import com.example.yumyay_chef.model.Category;
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
import com.example.yumyay_chef.model.Meal;
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;

import java.util.ArrayList;
import java.util.List;


<<<<<<< HEAD
public class HomePageFragment extends Fragment implements HomePageFragmentView,HomePageCategoryAdapter.OnCategoryClickListener,HomePageClickListener,CountryAdapter.OnCountryClickListener{
=======
public class HomePageFragment extends Fragment implements HomePageFragmentView,HomePageCategoryAdapter.OnCategoryClickListener {
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a

    public static final String TAG = "HomeActivity";
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
<<<<<<< HEAD
    private RecyclerView recyclerView4;
    private RecyclerView recyclerView5;

    private HomePageRandomAdapter homePageRandomAdapter;
    private HomePageCategoryAdapter homePageCategoryAdapter;
    private HomePageCategoryDetailsAdapter homePageCategoryDetailsAdapter;
    private CountryDetalisAdapter countryDetalisAdapter;
    private CountryAdapter countryAdapter;

    HomePagePresenter homePagePresenter;

    LinearLayoutManager linearLayout;
    LinearLayoutManager linearLayout2;
    LinearLayoutManager  linearLayout3;
    LinearLayoutManager  linearLayout4;
    LinearLayoutManager  linearLayout5;

    private ProgressBar progressBar3;
    private ProgressBar progressBar4;
    private ProgressBar progressBar5;
    private ProgressBar progressBar6;
    private ProgressBar progressBar7;


=======
    private HomePageRandomAdapter homePageRandomAdapter;
    private HomePageCategoryAdapter homePageCategoryAdapter;
    private HomePageCategoryDetailsAdapter homePageCategoryDetailsAdapter;
    HomePagePresenter homePagePresenter;
    LinearLayoutManager linearLayout;
    LinearLayoutManager linearLayout2;
    LinearLayoutManager  linearLayout3;
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);
<<<<<<< HEAD
        if (!NetworkFragment.isNetworkAvailable(getContext())) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, NetworkFragment.newInstance());
            transaction.addToBackStack(null);
            transaction.commit();
            return view;
        }
        else
        {
            hideProgressBarAfterDelay(progressBar3);
            hideProgressBarAfterDelay(progressBar4);
            hideProgressBarAfterDelay(progressBar5);
            hideProgressBarAfterDelay(progressBar6);
            hideProgressBarAfterDelay(progressBar7);
        }
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
        recyclerView.setHasFixedSize(true);
        linearLayout = new LinearLayoutManager(getActivity());
        homePageRandomAdapter = new HomePageRandomAdapter(getActivity(),new ArrayList<>());
        homePagePresenter = new HomePagePresenterImpl(this, MealsRepositoryImpl.getInstance(MealRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(getContext())));
        linearLayout.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(homePageRandomAdapter);

        recyclerView2.setHasFixedSize(true);
        linearLayout2 = new LinearLayoutManager(getActivity());
        homePageCategoryAdapter = new HomePageCategoryAdapter(getActivity(),new ArrayList<>());
        linearLayout2.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView2.setLayoutManager(linearLayout2);
        recyclerView2.setAdapter(homePageCategoryAdapter);

        homePageCategoryAdapter.setOnCategoryClickListener(this);
<<<<<<< HEAD

        recyclerView3.setHasFixedSize(true);
        linearLayout3 = new LinearLayoutManager(getActivity());
        homePageCategoryDetailsAdapter = new HomePageCategoryDetailsAdapter(getActivity(),new ArrayList<>(),this);
=======
        recyclerView3.setHasFixedSize(true);
        linearLayout3 = new LinearLayoutManager(getActivity());
        homePageCategoryDetailsAdapter = new HomePageCategoryDetailsAdapter(getActivity(),new ArrayList<>());
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
        linearLayout3.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView3.setLayoutManager(linearLayout3);
        recyclerView3.setAdapter(homePageCategoryDetailsAdapter);

<<<<<<< HEAD
        recyclerView4.setHasFixedSize(true);
        GridLayoutManager layoutManager4 = new GridLayoutManager(getActivity(), 2);
        //linearLayout4 = new LinearLayoutManager(getActivity());
        countryAdapter = new CountryAdapter(getActivity(),new ArrayList<>());
        layoutManager4.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView4.setLayoutManager(layoutManager4);
        recyclerView4.setAdapter(countryAdapter);

        recyclerView5.setHasFixedSize(true);
        linearLayout5 = new LinearLayoutManager(getActivity());
        countryDetalisAdapter = new CountryDetalisAdapter(getActivity(),new ArrayList<>(),this);
        linearLayout5.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView5.setLayoutManager(linearLayout5);
        recyclerView5.setAdapter(countryDetalisAdapter);

        countryAdapter.setOnCountryClickListener(this);
        homePagePresenter.getCountryHP();
        homePagePresenter.getRandomMealHP();
        homePagePresenter.getCategoryMealHP();
        homePagePresenter.getMealsByCategoryHP(HomePageCategoryAdapter.id);
        homePagePresenter.getMealsByCountryHP(CountryAdapter.name);
=======
        homePagePresenter.getRandomMealHP();
        homePagePresenter.getCategoryMealHP();
        homePagePresenter.getMealsByCategoryHP(HomePageCategoryAdapter.id);
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
        return  view;
    }
    private void initUI(View v){
        recyclerView = v.findViewById(R.id.recView);
        recyclerView2 = v.findViewById(R.id.recView2);
        recyclerView3=v.findViewById(R.id.recView3);
<<<<<<< HEAD
        recyclerView4=v.findViewById(R.id.recView4);
        recyclerView5=v.findViewById(R.id.recView5);

        progressBar3 = v.findViewById(R.id.progressBar3);
        progressBar4 = v.findViewById(R.id.progressBar4);
        progressBar5 = v.findViewById(R.id.progressBar5);
        progressBar6 = v.findViewById(R.id.progressBar6);
        progressBar7 = v.findViewById(R.id.progressBar7);

    }

    @Override
    public void showMealById(List<Meal> meal) {
        MealContentFragment mealFragment= MealContentFragment.getCurrentMeal(meal.get(0));
        FragmentTransaction fragmentTransaction = (getActivity()).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,mealFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void showMealByIdErrMsg(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(error).setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

=======
    }
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
    @Override
    public void showRandomMealData(List<Meal> meals) {
        homePageRandomAdapter.setList(meals);
        homePageRandomAdapter.notifyDataSetChanged();
    }
<<<<<<< HEAD

=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
    @Override
        public void showRandomMealErrMsg(String error) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(error).setTitle("An Error Occurred");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
<<<<<<< HEAD

        @SuppressLint("NotifyDataSetChanged")
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
        @Override
        public void showCategoryData(List<Category> categories) {
            homePageCategoryAdapter.setList(categories);
            homePageCategoryAdapter.notifyDataSetChanged();
        }
<<<<<<< HEAD

=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
        @Override
        public void showCategoryErrMsg(String error) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(error).setTitle("An Error Occurred");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
<<<<<<< HEAD

        @SuppressLint("NotifyDataSetChanged")
=======
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
        @Override
        public void showCategoryMeal(List<Meal> meal) {
            homePageCategoryDetailsAdapter.setList(meal);
            homePageCategoryDetailsAdapter.notifyDataSetChanged();
        }
        @Override
        public void showCategoryMealErrMsg(String error) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(error).setTitle("An Error Occurred");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
<<<<<<< HEAD

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void showCountryData(List<Country> countries) {
        countryAdapter.setList(countries);
        countryAdapter.notifyDataSetChanged();
    }

    @Override
    public void showCountryErrMsg(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(error).setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void showMealsByCountryData(List<Meal> meals) {
        countryDetalisAdapter.setList(meals);
        countryDetalisAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMealsByCountryErrMsg(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(error).setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
        public void onCategoryClick(String categoryId) {
            homePagePresenter.getMealsByCategoryHP(categoryId);
    }

    @Override
    public void onCountryClick(String selectedCountry) {
        homePagePresenter.getMealsByCountryHP(selectedCountry);
    }

    @Override
    public void onMealClick(String id) {
        homePagePresenter.getMealById(id);
    }

    private void hideProgressBarAfterDelay(final ProgressBar progressBar) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 3000);
    }
=======
        @Override
        public void onCategoryClick(String categoryId) {
            homePagePresenter.getMealsByCategoryHP(categoryId);
    }
>>>>>>> 47c590402c826035d665cdbd9cfe354d32a47e3a
}