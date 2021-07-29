package com.example.easy_tickets;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.sql.SQLException;

public class BusTicketInfo extends Fragment {
    private int cust_id,Bus_tripid;
    private TextView seats;
    TextView source,dest,agency,fare,date,time;
    Button btn;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.busticket_info, container, false);


        BusTicketItem item = (BusTicketItem) getArguments().getSerializable("Item");
        source=view.findViewById(R.id.inputSource);
        dest=view.findViewById(R.id.inputdest3);
        agency=view.findViewById(R.id.inputagency3);
        fare=view.findViewById(R.id.inputfare3);
        date=view.findViewById(R.id.inputdate3);
        time=view.findViewById(R.id.inputtime3);
        seats=view.findViewById(R.id.seats3);
        btn=view.findViewById(R.id.btn3);
        Log.i("kkkkk","mmmm");
        source.setText(item.getSource());
        dest.setText(item.getDestination());
        agency.setText(item.getAgency());
        date.setText(item.getDate());
        time.setText(item.getDate());
        fare.setText(String.valueOf(item.getTotalfare()));
        seats.setText(String.valueOf(item.getNo_seats()));
        Customer obj =new Customer(getActivity());
        Log.i("kkkkk","mmmm");

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("kkkkk","mmmm");
                int result=0;
                try {
                    result=obj.cancel_ticket(item.getTripid(),item.getCustid(),item.getTicketid());
                    Log.i(Integer.toString(item.getTripid()),Integer.toString(item.getTicketid()));

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if(result ==1)
                {
                    Fragment BusTripInfo = new BusTicketFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("custid",cust_id);
                    BusTripInfo.setArguments(bundle);
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, BusTripInfo);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });

        return view;
    }
}
