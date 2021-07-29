package com.example.easy_tickets;

import java.io.Serializable;

public class BusesTrip_item implements Serializable {
    private int bus;
    private String source;
    private String destination;
    private String date;
    private String time;
    private String Bus;
    public BusesTrip_item(int bus,String source,String destination,String date,String time,String Bus)
    {
        this.bus=bus;
        this.source=source;
        this.destination=destination;
        this.date=date;
        this.time=time;
        this.Bus=Bus;
    }

    public String getSource() {
        return source;
    }

    public int getBus() {
        return bus;
    }

    public String getBus2() {
        return Bus;
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

}
