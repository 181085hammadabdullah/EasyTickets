package com.example.easy_tickets;

import java.io.Serializable;

public class BusItem implements Serializable {
    private int bus;
    private String company;
    private String model;
    private String color;
    private String registration;
    private int seats;
    private int busid;
    private int agencyid;
    BusItem(int bus,String company,String model,String color,String registration,int seats)
    {
        this.bus=bus;
        this.company=company;
        this.model=model;
        this.color=color;
        this.registration=registration;
        this.seats=seats;
    }
    BusItem(int busid,String reg,int agencyid)
    {
        this.busid=busid;
        this.registration=reg;
        this.agencyid=agencyid;
    }
    public int getBus() {
        return bus;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public String getRegistration() {
        return registration;
    }

    public int getAgencyid() {
        return agencyid;
    }

    public int getBusid() {
        return busid;
    }
}
