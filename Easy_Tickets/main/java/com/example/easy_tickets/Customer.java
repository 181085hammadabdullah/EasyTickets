package com.example.easy_tickets;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer implements Serializable {
private String first_name;
private String last_name;
private String email;
private String password;
private String phone;
private String address;
private int balance;
private String name;
Context ctx;
Customer(){}
Customer(String first_name,String last_name,String email,String password)
{
    this.first_name=first_name;
    this.last_name=last_name;
    this.email=email;
    this.password=password;
}
    Customer(Context c)
    {
       ctx=c;
    }
    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }
    public  int SignUp(Customer obj) throws SQLException {

        CustomerDB obj1=new Customer_DB();
        return obj1.SignUp(obj,ctx);
    }
    public int Login(String email,String password) throws SQLException
    {

        CustomerDB obj1=new Customer_DB();
        return obj1.Login(email,password,ctx);
    }
    public int UpdateProfile() throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.UpdateProfile(this,ctx);
    }
    public void setContext(Context ctx)
    {
        this.ctx=ctx;
    }
    public void set(String first_name,String last_name,String email,String password)
    {
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.password=password;
    }
   Customer(String name,String email,String password,String phone,String address,int balance)
    {
       this.name=name;
        this.email=email;
        this.password=password;
        this.phone=phone;
        this.address=address;
        this.balance=balance;

    }
    Customer(String name,String email,String password,String phone,String address)
    {
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone=phone;
        this.address=address;
        this.balance=balance;

    }
public Customer getprofile(String email) throws SQLException
{
    CustomerDB obj1=new Customer_DB();
    return obj1.GetProfile(email,ctx);
}
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getBalance() {
        return balance;
    }

    public String getPhone() {
        return phone;
    }
    public ArrayList<Agency> GetAgencies() throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.GetAgencies(ctx);
    }
    public ArrayList<BusTripItem> GetBusTrips() throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.GetBusTrips(ctx);
    }
    public ArrayList<BusItem> GetBus() throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.GetBus(ctx);
    }
    public int GetCustid(String email) throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.GetCustid(email,ctx);
    }

    public int BookBusTrip(int Custid,int B_trip_id,int seats) throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.BookBusTrip(Custid,B_trip_id,seats,ctx);
    }

    //Train Trips Functions

    public ArrayList<TrainTripItem> GetTrainTrips() throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.GetTrainTrips(ctx);
    }
    public ArrayList<TrainItem> GetTrain() throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.GetTrain(ctx);
    }
    public int BookTrainTrip(int Custid,int B_trip_id,int seats) throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.BookTrainTrip(Custid,B_trip_id,seats,ctx);
    }

    public ArrayList<BusTicketItem> GetBusTicket(int custid) throws SQLException {
        Customer_DB obj1=new Customer_DB();
        ArrayList<BusTicketItem> List=new ArrayList<>();
        ArrayList<BusTicketItem> List1= obj1.GetBusTicket(ctx);
        for(BusTicketItem item:List1)
        {
            if(item.getCustid()==custid)
            {
                List.add(item);
            }
        }
        return List;
    }
    public ArrayList<BusTicketItem> GetBusTicket1(int custid) throws SQLException {
        Customer_DB obj1=new Customer_DB();
        ArrayList<BusTicketItem> List1= obj1.GetBusTicket(ctx);
        return List1;
    }
    public int cancel_ticket(int Trip_id, int cust_id,int ticketid) throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.CancelBookTrip(cust_id,Trip_id,ticketid,ctx);
    }
    public int AdminLogin(String email,String password) throws SQLException
    {

        CustomerDB obj1=new Customer_DB();
        return obj1.AdminLogin(email,password,ctx);
    }
    public Customer getAdminprofile(String email) throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.GetAdminProfile(email,ctx);
    }
    public int UpdateAdminProfile() throws SQLException
    {
        CustomerDB obj1=new Customer_DB();
        return obj1.UpdateAdminProfile(this,ctx);
    }
    public ArrayList<CustomerProfile_ItemA> GetCustomers() throws SQLException {
        Customer_DB obj1=new Customer_DB();
        ArrayList<CustomerProfile_ItemA> List1=obj1.GetCustomers(ctx);
        return List1;
    }
    public ArrayList<AgencyProfile_ItemA> GetAgencies1() throws SQLException {
        Customer_DB obj1=new Customer_DB();
        ArrayList<AgencyProfile_ItemA> List1=obj1.GetAgencies1(ctx);
        return List1;
    }
}
