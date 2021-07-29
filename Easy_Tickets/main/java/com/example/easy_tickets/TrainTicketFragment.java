package com.example.easy_tickets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainTicketFragment extends Fragment  {
    ArrayList<TrainTicketItem> List;
    private RecyclerView mRecycleView;
    private TrainTicketAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        List=new ArrayList<>();
        populate();
        View view=inflater.inflate(R.layout.fragment_trainticket, container, false);
        buildRecyclerView(view);
        return view;
    }
    public void sendItem(int position)
    {
        TrainTicketItem item=List.get(position);
        Fragment TrainTicketInfo = new TrainTicketInfo();
        Bundle arguments = new Bundle();
        arguments.putSerializable( "Trip", item);
        TrainTicketInfo.setArguments(arguments);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, TrainTicketInfo);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    public void buildRecyclerView(View view)
    {
        mRecycleView = view.findViewById(R.id.recyclerView1);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new TrainTicketAdapter(List);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new TrainTicketAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                sendItem(position);
                mAdapter.notifyItemChanged(position);
            }
        });
    }
    void populate()
    {
        List.add(new TrainTicketItem(R.drawable.ic_baseline_train_24,"Lahore","Sargodha","6/12/2021","12:12","Daewoo",1500,3));
        List.add(new  TrainTicketItem(R.drawable.ic_baseline_train_24,"Islamabad","Karachi","7/12/2021","14:18","Rahbar",1200,5));
        List.add(new  TrainTicketItem(R.drawable.ic_baseline_train_24,"Fasilabad","Narowal","8/12/2021","11:13","Niazi",1300,6));
        List.add(new  TrainTicketItem(R.drawable.ic_baseline_train_24,"Sukkhar","RWP","10/12/2021","10:18","Skyways",1400,7));
    }
}
