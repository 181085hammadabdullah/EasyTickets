package com.example.easy_tickets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BusesTrips extends Fragment {

    private int GLOBAL_POS;
    ArrayList<BusesTrip_item> List;
    private RecyclerView mRecycleView;
    private BusesTripsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    View view1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        List = new ArrayList<>();
        View view = inflater.inflate(R.layout.buses_trip_list, container, false);
        populate();

        buildRecyclerView(view);
        Button btn1=view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Edit_profileFragment = new AddBusTrip();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, Edit_profileFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        view1=view;
        return view;
    }
    public void sendItem(int position)
    {
        BusesTrip_item item=List.get(position);
        Fragment BusTripInfo = new EditBusTrip();
        Bundle arguments = new Bundle();
        arguments.putSerializable( "Trip", item);
        BusTripInfo.setArguments(arguments);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, BusTripInfo);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    public void buildRecyclerView(View view) {
        mRecycleView = view.findViewById(R.id.recyclerView1);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new BusesTripsAdapter(List);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BusesTripsAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                sendItem(position);
                mAdapter.notifyItemChanged(position);
            }
        });

    }

    void populate() {
        List.add(new com.example.easy_tickets.BusesTrip_item(R.drawable.ic_baseline_bus_alert_24,"Lahore","Sargodha","6/12/2021","12:12","Daewoo"));
        List.add(new com.example.easy_tickets.BusesTrip_item(R.drawable.ic_baseline_bus_alert_24,"Islamabad","Karachi","7/12/2021","14:18","Rahbar"));
        List.add(new com.example.easy_tickets.BusesTrip_item(R.drawable.ic_baseline_bus_alert_24,"Fasilabad","Narowal","8/12/2021","11:13","Niazi"));
        List.add(new com.example.easy_tickets.BusesTrip_item(R.drawable.ic_baseline_bus_alert_24,"Sukkhar","RWP","10/12/2021","10:18","Skyways"));

    }

}

