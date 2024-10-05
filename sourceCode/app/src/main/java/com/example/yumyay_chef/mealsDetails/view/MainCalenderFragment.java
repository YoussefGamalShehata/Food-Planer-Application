package com.example.yumyay_chef.mealsDetails.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.yumyay_chef.R;

import java.util.Calendar;

public class MainCalenderFragment extends DialogFragment {
    int day;
    int month;
    int year;
    private OnDateSelectedListener listener;
    public interface OnDateSelectedListener {
        void onDateSelected(String date);
    }

    public void setOnDateSelectedListener(OnDateSelectedListener listener) {
        this.listener = listener;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_calender2, null);

        DatePicker datePicker = view.findViewById(R.id.datePicker);
        Button btnSelectDate = view.findViewById(R.id.btnSelectDate);


        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(view);

        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null);
        datePicker.setMinDate(calendar.getTimeInMillis());
        btnSelectDate.setOnClickListener(v -> {
            day = datePicker.getDayOfMonth();
            month = datePicker.getMonth() + 1;
            year = datePicker.getYear();

            String selectedDate = day + "/" + month + "/" + year;


            if (listener != null) {
                listener.onDateSelected(selectedDate);
            }

            dialog.dismiss();
        });

        return dialog;
    }
}
