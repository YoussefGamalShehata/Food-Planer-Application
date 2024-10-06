package com.example.yumyay_chef.calender.view;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.yumyay_chef.R;
import com.example.yumyay_chef.calender.presenter.CalenderPresenter;
import com.example.yumyay_chef.calender.presenter.CalenderPresenterImpl;
import com.example.yumyay_chef.db.MealsLocalDataSourceImpl;
import com.example.yumyay_chef.model.MealPlan;
import com.example.yumyay_chef.model.MealsRepositoryImpl;
import com.example.yumyay_chef.network.MealRemoteDataSourceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalenderFragment extends Fragment implements CalenderView,OnCalenderClickListener {


    CalenderPresenter calendarPresenter;
    private RecyclerView recyclerViewFav;
    private CalenderAdapter adapter;
    LinearLayoutManager layoutManager;
    private String date="";
    LiveData<List<MealPlan>> plannedFood;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calender, container, false);
        DatePicker datePicker = view.findViewById(R.id.datePicker2);
        Calendar calendar = Calendar.getInstance();
        datePicker.setMinDate(calendar.getTimeInMillis());
        recyclerViewFav=view.findViewById(R.id.recPlaned);
        calendarPresenter =new CalenderPresenterImpl( MealsRepositoryImpl.getInstance(MealRemoteDataSourceImpl.getInstance(),
                MealsLocalDataSourceImpl.getInstance(getContext())));

        adapter=new CalenderAdapter(getContext(),new ArrayList<MealPlan>(),this);
        recyclerViewFav.setAdapter(adapter);
        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewFav.setLayoutManager(layoutManager);




        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Format the selected date
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

                        plannedFood=calendarPresenter.getPlanedMeal(selectedDate);
                        plannedFood.observe(getViewLifecycleOwner(), new Observer<List<MealPlan>>() {
                            @Override
                                public void onChanged(List<MealPlan> mealPlans) {
                                // Update the adapter with new data
                                showData(mealPlans);
                            }
                        });

                        // Send the selected date to another fragment or handle it
                        Bundle result = new Bundle();
                        result.putString("selectedDate", selectedDate);
                        getParentFragmentManager().setFragmentResult("requestKey", result);

                        // Show selected date in a Toast (for testing purposes)
                        Toast.makeText(getContext(), "Selected Date: " + selectedDate, Toast.LENGTH_SHORT).show();
                    }
                });
        return view;
    }

    @Override
    public void showData(List<MealPlan> mealPlans) {
        adapter.setList(mealPlans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrMsg(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(error).setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onLayoutClick(MealPlan mealPlan) {
        Toast.makeText(getContext(), mealPlan.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemoveClick(MealPlan mealPlan) {
        calendarPresenter.removeFromFav(mealPlan);
        adapter.notifyDataSetChanged();
    }
}