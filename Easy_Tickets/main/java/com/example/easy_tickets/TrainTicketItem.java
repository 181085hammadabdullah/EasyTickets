package com.example.easy_tickets;

import java.io.Serializable;

public class TrainTicketItem implements Serializable {
    private int train;
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
    TrainTicketItem(int train,String source,String destination,String Date,String Time,String Agency,int totalfare,int no_seats){
        this.train=train;
        this.source=source;
        this.destination=destination;
        this.date=Date;
        this.time=Time;
        this.Agency=Agency;
        this.totalfare=totalfare;
        this.no_seats=no_seats;
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

    public int getTrain() {
        return train;
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
}
