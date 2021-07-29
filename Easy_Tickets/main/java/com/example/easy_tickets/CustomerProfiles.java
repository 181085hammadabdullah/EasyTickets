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

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerProfiles extends Fragment {


    ArrayList<CustomerProfile_ItemA> List;
    private RecyclerView mRecycleView;
    private CustomerProfileAdapterA mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        List=new ArrayList<>();
        View view= inflater.inflate(R.layout.customer_profiles, container, false);
        //populate();
        Customer obj=new Customer(getActivity());
        try {
            List=obj.GetCustomers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        buildRecyclerView(view);
        return view;
    }
    public void sendItem(int position)
    {
        CustomerProfile_ItemA item=List.get(position);
        Fragment CustomerProfile = new CustomerProfile();
        Bundle arguments = new Bundle();
        arguments.putSerializable( "profile", item);
        CustomerProfile.setArguments(arguments);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, CustomerProfile);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    public void buildRecyclerView(View view)
    {
        mRecycleView = view.findViewById(R.id.recyclerView1);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new CustomerProfileAdapterA(List);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CustomerProfileAdapterA.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                sendItem(position);
                mAdapter.notifyItemChanged(position);
            }
        });
    }
    void populate()
    {
        List.add(new CustomerProfile_ItemA(R.drawable.ic_baseline_person_24,"hammad","hammad@gmail.com","0303030303"));
        List.add(new CustomerProfile_ItemA(R.drawable.ic_baseline_person_24,"hammad","hammad@gmail.com","0303030303"));
        List.add(new CustomerProfile_ItemA(R.drawable.ic_baseline_person_24,"hammad","hammad@gmail.com","0303030303"));
        List.add(new CustomerProfile_ItemA(R.drawable.ic_baseline_person_24,"hammad","hammad@gmail.com","0303030303"));

    }
}
