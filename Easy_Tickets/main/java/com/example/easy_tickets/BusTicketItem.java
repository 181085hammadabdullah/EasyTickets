package com.example.easy_tickets;

import java.io.Serializable;

public class BusTicketItem implements Serializable {
    private int bus;
    private int ticketid;
    private int tripid;
    private String source;
    private String destination;
    private String date;
    private String time;
    private String Agency;
    private int totalfare;
    private int no_seats;
    private int seats[];
    private int custid;
    private String status;

    BusTicketItem(int bus,int tripid,String source,String destination,String Date,String Agency,int totalfare,int no_seats,String status,int cust_id){
        this.bus=bus;
        this.source=source;
        this.destination=destination;
        this.date=Date;

        this.Agency=Agency;
        this.totalfare=totalfare;
        this.no_seats=no_seats;
        this.status=status;
        this.custid=cust_id;
        this.tripid=tripid;

    }
    BusTicketItem(int tripid,int custid,int ticketid,String date,String status,int seats,int totalfare)
    {
        this.tripid=tripid;
        this.custid=custid;
        this.ticketid=ticketid;
        this.date=date;
        this.status=status;
        this.no_seats=seats;
        this.totalfare=totalfare;

    }
    public String getTime() {
        return time;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getAgency() {
        return Agency;
    }

    public int getBus() {
        return bus;
    }

    public int getNo_seats() {
        return no_seats;
    }

    public int getTicketid() {
        return ticketid;
    }

    public int getTotalfare() {
        return totalfare;
    }

    public int getTripid() {
        return tripid;
    }

    public int[] getSeats() {
        return seats;
    }

    public int getCustid() {
        return custid;
    }

    public String getStatus() {
        return status;
    }
}
