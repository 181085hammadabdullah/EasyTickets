package com.example.easy_tickets;

import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDB {
    public int SignUp(Customer obj, Context c) throws SQLException;
    public int Login(String email,String password, Context c) throws SQLException;
    public int AdminLogin(String email,String password, Context c) throws SQLException;
    public Customer GetProfile(String email,Context c) throws SQLException;
    public int UpdateProfile(Customer obj,Context c) throws SQLException;
    public Customer GetAdminProfile(String email,Context c) throws SQLException;
    public int UpdateAdminProfile(Customer obj,Context c) throws SQLException;
    public ArrayList<CustomerProfile_ItemA> GetCustomers(Context c) throws SQLException;
    public ArrayList<AgencyProfile_ItemA> GetAgencies1(Context c) throws SQLException;
    public ArrayList<Agency> GetAgencies(Context c) throws SQLException;
    public ArrayList<BusTripItem> GetBusTrips(Context c) throws SQLException;
    public ArrayList<BusItem> GetBus(Context c) throws SQLException;
    public int GetCustid(String email,Context c) throws SQLException;
    public int BookBusTrip(int Custid,int B_trip_id,int seats,Context c) throws SQLException;
    public int CancelBookTrip(int Custid,int B_trip_id,int ticketid,Context c) throws SQLException;
    //Train Trips
    public ArrayList<TrainTripItem> GetTrainTrips(Context c) throws SQLException;
    public ArrayList<TrainItem> GetTrain(Context c) throws SQLException;
    public int BookTrainTrip(int Custid,int B_trip_id,int seats,Context c) throws SQLException;
    public ArrayList<BusTicketItem> GetBusTicket(Context c) throws SQLException;
}
