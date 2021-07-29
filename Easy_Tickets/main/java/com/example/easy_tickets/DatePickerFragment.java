package com.example.easy_tickets;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
private  String date;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

      date=year+"-"+(month+1)+"-"+dayOfMonth;
      if(BusTripFragment.set_date!=null)
      {
          BusTripFragment.set_date.setText(date);
      }
      if(TrainTripFragment.set_date!=null) {
        TrainTripFragment.set_date.setText(date);
    }
      if(AddBusTrip.set_date!=null)
      {
          AddBusTrip.set_date.setText(date);
      }
        if(EditBusTrip.set_date!=null)
        {
           EditBusTrip.set_date.setText(date);
        }
        if(AddTrainTrip.set_date!=null)
        {
            AddBusTrip.set_date.setText(date);
        }
        if(EditTrainTrip.set_date!=null)
        {
            EditBusTrip.set_date.setText(date);
        }
    }


}
