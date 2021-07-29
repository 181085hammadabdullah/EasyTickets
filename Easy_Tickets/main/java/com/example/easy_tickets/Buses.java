package com.example.easy_tickets;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Buses extends Fragment  {

    private int GLOBAL_POS;
    ArrayList<BusItem> List;
    private RecyclerView mRecycleView;
    private BusesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    View view1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        List = new ArrayList<>();
        View view = inflater.inflate(R.layout.buses_list, container, false);
        populate();

        buildRecyclerView(view);
        Button btn1=view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Edit_profileFragment = new AddBus();
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
        BusItem item=List.get(position);
        Fragment BusTripInfo = new EditBus();
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
        mAdapter = new BusesAdapter(List);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BusesAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                sendItem(position);
                mAdapter.notifyItemChanged(position);
            }
        });

    }

    void populate() {
        List.add(new BusItem(R.drawable.ic_baseline_directions_bus_24, "Toyota", "2015", "Red","",50));
        List.add(new BusItem(R.drawable.ic_baseline_directions_bus_24, "Toyota", "2015", "Red","",50));
        List.add(new BusItem(R.drawable.ic_baseline_directions_bus_24, "Toyota", "2015", "Red","",50));
        List.add(new BusItem(R.drawable.ic_baseline_directions_bus_24, "Toyota", "2015", "Red","",50));

    }

}
