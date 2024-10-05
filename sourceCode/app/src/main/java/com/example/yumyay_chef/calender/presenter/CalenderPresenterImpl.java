package com.example.yumyay_chef.calender.presenter;

import androidx.lifecycle.LiveData;

import com.example.yumyay_chef.model.MealPlan;
import com.example.yumyay_chef.model.MealsRepository;

import java.util.List;

public class CalenderPresenterImpl implements CalenderPresenter{

   //private CalendarView _view;
    private MealsRepository _repo;

    public CalenderPresenterImpl( MealsRepository _repo ) {
       // this._view = _view;
        this._repo = _repo;
    }
    //    public void setDate(String date){
//        this.date=date;
//    }
    @Override
    public LiveData<List<MealPlan>> getPlanedFood(String date) {
        return _repo.getPlannedMeal(date);
    }

    @Override
    public void removeFromFav(MealPlan foodPlan) {
        _repo.deleteMealPlan(foodPlan);
    }

}
