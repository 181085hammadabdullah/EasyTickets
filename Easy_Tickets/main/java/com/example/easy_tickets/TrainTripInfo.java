package com.example.easy_tickets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.sql.SQLException;

public class TrainTripInfo extends Fragment {
    private int cust_id,Bus_tripid;
    private EditText seats;
    TextView source,dest,agency,fare,date,time;
    Button btn;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.traintrip_info, container, false);
        source=view.findViewById(R.id.inputSource);
        dest=view.findViewById(R.id.inputdest3);
        agency=view.findViewById(R.id.inputagency3);
        fare=view.findViewById(R.id.inputfare3);
        date=view.findViewById(R.id.inputdate3);
        time=view.findViewById(R.id.inputtime3);
        seats=view.findViewById(R.id.seats3);
        btn=view.findViewById(R.id.btn3);

        cust_id = getArguments().getInt("Cust_id");
        Bus_tripid = getArguments().getInt("B_Trip_id");
        String source1 = getArguments().getString("source");
        String destination1 = getArguments().getString("destination");
        String agency1 = getArguments().getString("agency");
        String date1 = getArguments().getString("date");
        String time1 = getArguments().getString("time");
        int fare1=getArguments().getInt("fare");

        source.setText(source1);
        dest.setText(destination1);
        agency.setText(agency1);
        date.setText(date1);
        time.setText(time1);
        fare.setText(String.valueOf(fare1));
        Customer obj =new Customer(getActivity());

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int result=0;

                try {
                    result=obj.BookTrainTrip(cust_id,Bus_tripid,Integer.parseInt(seats.getText().toString()));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                Fragment BusTripInfo = new TrainTicketFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("result",result);
                BusTripInfo.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, BusTripInfo);
                transaction.addToBackStack(null);
                transaction.commit();
            }

        });
        return view;
    }
}
