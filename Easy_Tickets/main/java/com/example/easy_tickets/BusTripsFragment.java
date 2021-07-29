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

public class BusTripsFragment extends Fragment  {
    ArrayList<BusTripItem> List;
    ArrayList<BusTripItem> List4;
    ArrayList<BusItem> List2;
    ArrayList<BusItem> List3;
    private RecyclerView mRecycleView;
    private BusTripAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String email;
    private int id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        List=new ArrayList<>();
        List3=new ArrayList<>();
        List4=new ArrayList<>();
       View view= inflater.inflate(R.layout.fragment_bustrips, container, false);
         email = getArguments().getString("email");
        String source = getArguments().getString("source");
        String destination = getArguments().getString("destination");
        String agency = getArguments().getString("agency");
        String date = getArguments().getString("date");
        String time = getArguments().getString("time");
        int index=getArguments().getInt("index");

        Customer obj=new Customer(getActivity());
        try {
            List=obj.GetBusTrips();
            List2=obj.GetBus();
            id= obj.GetCustid(email);
            for(BusItem item:List2)
            {
                if(item.getAgencyid()==index)
                {
                    List3.add(item);
                }
            }
            Log.i("size",String.valueOf(List.size()));
            for(BusItem item:List3)
            {

                BusTripItem item2=null;
                int check=0;
                for(BusTripItem item1:List)
                {

                    if(item.getBusid()==item1.getBus_id()){
                        check=1;
                        item2=item1;
                        item2.setAgency(agency);
                        item2.setBus(R.drawable.ic_baseline_bus_alert_24);
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
        String[] arrOfStr1 = date.split("-", 3);
        int year1=Integer.valueOf(arrOfStr1[0]);
        int mon1=Integer.valueOf(arrOfStr1[1]);
        int day1=Integer.valueOf(arrOfStr1[2]);
        for(BusTripItem item1:List4) {
            String[] arrOfStr = item1.getDate().split("-", 3);
            Log.i(arrOfStr[0],arrOfStr[1]);
            Log.i(arrOfStr[2],"hhh");
            int year=Integer.valueOf(arrOfStr[0]);
            int mon=Integer.valueOf(arrOfStr[1]);
            int day=Integer.valueOf(arrOfStr[2]);
            if(item1.getSource().equals(source) && item1.getDestination().equals(destination))
            {
                if(year==year1 && mon==mon1 && day==day1)
                {
                    List.add(item1);
                }


            }
        }
        Log.i("date",date);

        buildRecyclerView(view);
        return view;
    }
    public void sendItem(int position)
    {
        com.example.easy_tickets.BusTripItem item=List.get(position);
        Fragment BusTripInfo = new BusTripInfo();

        Bundle bundle = new Bundle();
        bundle.putInt("Cust_id",id);
        bundle.putInt("B_Trip_id",item.getBus_id());
        bundle.putString("source",item.getSource());
        bundle.putString("destination",item.getDestination());
        bundle.putString("agency",item.getAgency());
        bundle.putString("date",item.getDate());
        bundle.putString("time",item.getTime());
        bundle.putInt("fare",item.getFare());
        BusTripInfo.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, BusTripInfo);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    public void buildRecyclerView(View view)
    {
        mRecycleView = view.findViewById(R.id.recyclerView1);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new BusTripAdapter(List);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BusTripAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                sendItem(position);
                mAdapter.notifyItemChanged(position);
            }
        });
    }
    void populate()
    {
       List.add(new com.example.easy_tickets.BusTripItem(R.drawable.ic_baseline_bus_alert_24,"Lahore","Sargodha","6/12/2021","12:12","Daewoo"));
       List.add(new com.example.easy_tickets.BusTripItem(R.drawable.ic_baseline_bus_alert_24,"Islamabad","Karachi","7/12/2021","14:18","Rahbar"));
       List.add(new com.example.easy_tickets.BusTripItem(R.drawable.ic_baseline_bus_alert_24,"Fasilabad","Narowal","8/12/2021","11:13","Niazi"));
       List.add(new com.example.easy_tickets.BusTripItem(R.drawable.ic_baseline_bus_alert_24,"Sukkhar","RWP","10/12/2021","10:18","Skyways"));
    }

}
