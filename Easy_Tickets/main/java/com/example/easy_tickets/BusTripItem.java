package com.example.easy_tickets;

import java.io.Serializable;

public class BusTripItem implements Serializable {
private int bus;
private int id;
private String source;
private String destination;
private String date;
private String time;
private String Agency;
private int fare;
private int Total_seats;
private int Bus_id;

    BusTripItem(){}
 BusTripItem(int bus,String source,String destination,String date,String time,String Agency)
{
    this.bus=bus;
    this.source=source;
    this.destination=destination;
    this.date=date;
    this.time=time;
    this.Agency=Agency;
}
     BusTripItem(int id,String source,String destination,String date,String time,String Agency,int fare,int Total_seats,int Bus_id)
    {
        this.id=id;
        this.source=source;
        this.destination=destination;
        this.date=date;
        this.time=time;
        this.Agency=Agency;
        this.fare=fare;
        this.Total_seats=Total_seats;
        this.Bus_id=Bus_id;
    }

    public String getSource() {
        return source;
    }

    public int getBus() {
        return bus;
    }

    public String getAgency() {
        return Agency;
    }

    public String getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public String getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public int getBus_id() {
        return Bus_id;
    }

    public int getFare() {
        return fare;
    }

    public int getTotal_seats() {
        return Total_seats;
    }

    public void setAgency(String agency) {
        Agency = agency;
    }

    public void setBus(int bus) {
        this.bus = bus;
    }
}
