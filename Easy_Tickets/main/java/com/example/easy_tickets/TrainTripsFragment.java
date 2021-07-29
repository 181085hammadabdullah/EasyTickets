package com.example.easy_tickets;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainTripsFragment extends Fragment  {
    ArrayList<TrainTripItem> List;
    ArrayList<com.example.easy_tickets.TrainTripItem> List4;
    ArrayList<com.example.easy_tickets.TrainItem> List2;
    ArrayList<com.example.easy_tickets.TrainItem> List3;
    private RecyclerView mRecycleView;
    private TrainTripAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String email;
    private int id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        List=new ArrayList<>();
        List3=new ArrayList<>();
        List4=new ArrayList<>();
       View view= inflater.inflate(R.layout.fragment_traintrips, container, false);
        email = getArguments().getString("email");
        String source = getArguments().getString("source");
        String destination = getArguments().getString("destination");
        String agency = getArguments().getString("agency");
        String date = getArguments().getString("date");
        String time = getArguments().getString("time");
        int index=getArguments().getInt("index");

        Customer obj=new Customer(getActivity());
        try {
           List=obj.GetTrainTrips();
           List2=obj.GetTrain();
            id= obj.GetCustid(email);
            for(TrainItem item:List2)
            {
                if(item.getAgencyid()==index)
                {
                    List3.add(item);
                }
            }
            for(TrainItem item:List3)
            {
                TrainTripItem item2=null;
                int check=0;
                for(TrainTripItem item1:List)
                {

                    if(item.getTrainid()==item1.getTrain_id()){
                        check=1;
                        item2=item1;
                        item2.setAgency(agency);
                        item2.setTrain(R.drawable.ic_baseline_bus_alert_24);
                    }
                }
                if(check==1)
                {
                    List4.add(item2);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List=new ArrayList<>();
        for(TrainTripItem item1:List4) {
            if(item1.getSource().equals(source) && item1.getDestination().equals(destination))
            {
                List.add(item1);
            }
        }
        buildRecyclerView(view);
        return view;
    }
    public void sendItem(int position)
    {
        TrainTripItem item=List.get(position);
        Fragment TrainTripInfo = new TrainTripInfo();
        Bundle bundle = new Bundle();
        bundle.putInt("Cust_id",id);
        bundle.putInt("T_Trip_id",item.getTrain_id());
        bundle.putString("source",item.getSource());
        bundle.putString("destination",item.getDestination());
        bundle.putString("agency",item.getAgency());
        bundle.putString("date",item.getDate());
        bundle.putString("time",item.getTime());
        bundle.putInt("fare",item.getFare());
        TrainTripInfo.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, TrainTripInfo);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void buildRecyclerView(View view)
    {
        mRecycleView = view.findViewById(R.id.recyclerView2);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new TrainTripAdapter(List);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new TrainTripAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                sendItem(position);
                mAdapter.notifyItemChanged(position);
            }
        });
    }
    void populate()
    {
        List.add(new TrainTripItem(R.drawable.ic_baseline_train_24,"Lahore","Sargodha","6/12/2021","12:12","Daewoo"));
        List.add(new TrainTripItem(R.drawable.ic_baseline_train_24,"Islamabad","Karachi","7/12/2021","14:18","Rahbar"));
        List.add(new TrainTripItem(R.drawable.ic_baseline_train_24,"Fasilabad","Narowal","8/12/2021","11:13","Niazi"));
        List.add(new TrainTripItem(R.drawable.ic_baseline_train_24,"Sukkhar","RWP","10/12/2021","10:18","Skyways"));
    }

}
