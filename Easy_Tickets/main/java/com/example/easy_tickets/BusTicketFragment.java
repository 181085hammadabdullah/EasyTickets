package com.example.easy_tickets;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.BIND_AUTO_CREATE;

public class BusTicketFragment extends Fragment  {

    ArrayList<BusTicketItem> BusTicketList1;
    ArrayList<BusTicketItem> BusTicketList;
    ArrayList<BusTripItem> BustTripList;
    ArrayList<BusItem> BusList;
    ArrayList<BusItem> BusList1;
    private java.util.List<Agency> AgencyList;
    private RecyclerView mRecycleView;
    private BusTicketAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private  String strAr[];
    private  int Ar[];
   CustomerService boundService;
    boolean isBound = false;
    private int custid;
    View view2;
    private AdView adView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        BusTicketList=new ArrayList<>();
        BustTripList=new ArrayList<>();
        BusList=new ArrayList<>();
        BusList1=new ArrayList<>();
        BusTicketList1=new ArrayList<>();
        View view=inflater.inflate(R.layout.fragment_busticket, container, false);

        adView = view.findViewById(R.id.ad_view);
        MobileAds.initialize(getActivity());
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);


        custid = getArguments().getInt("custid");


        view2=view;
        buildRecyclerView(view);
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        Intent intent = new Intent(getActivity(), CustomerService.class);
        getActivity().startService(intent);
        getActivity().bindService(intent , boundServiceConnection,BIND_AUTO_CREATE);
        Log.i("jjj","lll");
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void sendItem(int position)
    {
        BusTicketItem item=BusTicketList1.get(position);
        Fragment BusTicketInfo = new BusTicketInfo();
        Bundle arguments = new Bundle();
        arguments.putSerializable( "Item", item);
        BusTicketInfo.setArguments(arguments);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, BusTicketInfo);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void buildRecyclerView(View view)
    {
        mRecycleView = view.findViewById(R.id.recyclerView1);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new BusTicketAdapter(BusTicketList1);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BusTicketAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                sendItem(position);
                mAdapter.notifyItemChanged(position);
            }
        });
    }
    private ServiceConnection boundServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CustomerService.MyBinder binderBridge = (CustomerService.MyBinder) service ;
            boundService = binderBridge.getService();
            isBound = true;
            Log.i("hhhh",String.valueOf(boundService.ResultFromDB2(custid,getActivity())));
            BusTicketList1=boundService.ResultFromDB2(custid,getActivity());
            buildRecyclerView(view2);


        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
            boundService= null;
        }
    };

}
