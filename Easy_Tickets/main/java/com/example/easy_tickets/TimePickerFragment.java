package com.example.easy_tickets;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String currentDateString = hourOfDay+":"+minute;
        if(BusTripFragment.set_time!=null)
        {
            BusTripFragment.set_time.setText(currentDateString);
        }
        if(TrainTripFragment.set_time!=null) {
            TrainTripFragment.set_time.setText(currentDateString);
        }
        if(AddBusTrip.set_time!=null)
        {
            AddBusTrip.set_time.setText(currentDateString);
        }
        if(EditBusTrip.set_time!=null)
        {
            EditBusTrip.set_time.setText(currentDateString);
        }
        if(AddTrainTrip.set_time!=null)
        {
            AddBusTrip.set_time.setText(currentDateString);
        }
        if(EditTrainTrip.set_time!=null)
        {
            EditBusTrip.set_time.setText(currentDateString);
        }
    }
}
