package com.example.easy_tickets;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.sql.SQLException;
import java.util.List;

public class BusTripFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private static Button date, time,btn2;
    public static TextView set_date, set_time;
    private static final int Date_id = 0;
    private static final int Time_id = 1;
    private  List<Agency> arr;
    private  String strAr[];
    private  int Ar[];
    private String source,destination,agency;
    private int index;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_bustrip, container, false);
        String email = getArguments().getString("email");
        date = (Button) view.findViewById(R.id.selectdate);
        time=(Button) view.findViewById(R.id.selecttime);
        set_date = (TextView) view.findViewById(R.id.set_date);
        set_time=(TextView) view.findViewById(R.id.set_time);
        Customer obj=new Customer(getActivity());
        try {
             arr=obj.GetAgencies();
             strAr=new String[arr.size()];
             Ar=new int[arr.size()];
            int i=0;
            for(Agency item:arr)
            {
                Ar[i]=item.getId();
                strAr[i++]=item.getName();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        btn2=(Button) view.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment BusTripsFragment = new BusTripsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("email",email);
                bundle.putString("source",source);
                bundle.putString("destination",destination);
                bundle.putString("agency",agency);
                bundle.putString("date",set_date.getText().toString());
                bundle.putString("time",set_time.getText().toString());
                bundle.putInt("index",index);
                BusTripsFragment.setArguments(bundle);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, BusTripsFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getActivity().getSupportFragmentManager(), "time picker");
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getActivity().getSupportFragmentManager() , "DatePicker");


            }
        });
        Spinner source=view.findViewById(R.id.Source);
        Spinner destination=view.findViewById(R.id.dest);
        Spinner agency=view.findViewById(R.id.agency);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(),   android.R.layout.simple_spinner_item, strAr);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        source.setAdapter(adapter);
        source.setOnItemSelectedListener(this);
        destination.setAdapter(adapter);
        destination.setOnItemSelectedListener(this);
        agency.setAdapter(spinnerArrayAdapter);
        agency.setOnItemSelectedListener(this);
        return view;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        if(spinner.getId()==R.id.Source)
        {
            source = parent.getItemAtPosition(position).toString();
            index=Ar[position];

        }
        if(spinner.getId()==R.id.dest)
        {
            destination = parent.getItemAtPosition(position).toString();

        }
        if(spinner.getId()==R.id.agency)
        {
            agency = parent.getItemAtPosition(position).toString();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
