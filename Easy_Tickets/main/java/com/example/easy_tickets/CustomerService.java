package com.example.easy_tickets;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerService extends Service {
    ArrayList<BusTicketItem> BusTicketList1;
    ArrayList<BusTicketItem> BusTicketList;
    ArrayList<BusTripItem> BustTripList;
    ArrayList<BusItem> BusList;
    ArrayList<BusItem> BusList1;
    private  String strAr[];
    private  int Ar[];
    private java.util.List<Agency> AgencyList;
    public CustomerService() {
    }
    private final IBinder localBinder = new MyBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public class MyBinder extends Binder {
        public CustomerService getService() {
            return CustomerService.this;
        }
    }
    public Customer ResultFromDB(String email) throws SQLException {

        Customer obj =new Customer(this);
        Customer obj1 =  obj.getprofile(email);
        return obj1;
    }
    public  ArrayList<BusTicketItem> ResultFromDB2(int custid, Context ctx)  {
        if(custid!=0)
        {
            BusTicketList=new ArrayList<>();
            BustTripList=new ArrayList<>();
            BusList=new ArrayList<>();
            BusList1=new ArrayList<>();
            BusTicketList1=new ArrayList<>();
            Customer obj =new Customer(ctx);
            try {
                BusTicketList=obj.GetBusTicket(custid);
                BustTripList=obj.GetBusTrips();
                BusList=obj.GetBus();
                AgencyList=obj.GetAgencies();
                strAr=new String[AgencyList.size()];
                Ar=new int[AgencyList.size()];

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            for(BusTicketItem item1:BusTicketList)
            {
                for(BusTripItem item2:BustTripList)
                {
                    if(item1.getTripid()==item2.getId())
                    {
                        for(BusItem item3:BusList) {
                            if (item2.getBus_id() == item3.getBusid())
                            {
                                for(Agency item4:AgencyList)
                                {
                                    if(item3.getAgencyid()==item4.getId())
                                    {
                                        BusTicketItem obj2= new BusTicketItem(R.drawable.ic_baseline_bus_alert_24,item1.getTripid(),item2.getSource(),item2.getDestination(),item1.getDate(),item4.getName(),item1.getTotalfare(), item1.getNo_seats(),item1.getStatus(),item1.getCustid());
                                        BusTicketList1.add(obj2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else
        {
            BusTicketList=new ArrayList<>();
            BustTripList=new ArrayList<>();
            BusList=new ArrayList<>();
            BusList1=new ArrayList<>();
            BusTicketList1=new ArrayList<>();
            Customer obj =new Customer(ctx);
            try {
                BusTicketList=obj.GetBusTicket1(custid);
                BustTripList=obj.GetBusTrips();
                BusList=obj.GetBus();
                AgencyList=obj.GetAgencies();
                strAr=new String[AgencyList.size()];
                Ar=new int[AgencyList.size()];

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            for(BusTicketItem item1:BusTicketList)
            {
                for(BusTripItem item2:BustTripList)
                {
                    if(item1.getTripid()==item2.getId())
                    {
                        for(BusItem item3:BusList) {
                            if (item2.getBus_id() == item3.getBusid())
                            {
                                for(Agency item4:AgencyList)
                                {
                                    if(item3.getAgencyid()==item4.getId())
                                    {
                                        BusTicketItem obj2= new BusTicketItem(R.drawable.ic_baseline_bus_alert_24,item1.getTripid(),item2.getSource(),item2.getDestination(),item1.getDate(),item4.getName(),item1.getTotalfare(), item1.getNo_seats(),item1.getStatus(),item1.getCustid());
                                        BusTicketList1.add(obj2);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }




        return  BusTicketList1;
    }
}
