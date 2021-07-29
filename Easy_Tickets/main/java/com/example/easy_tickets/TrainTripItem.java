package com.example.easy_tickets;

import java.io.Serializable;

public class TrainTripItem implements Serializable {
private int train;
private String source;
private String destination;
private String date;
private String time;
private String Agency;
private int fare;
private int Total_seats;
private int Train_id;
private int id;
public TrainTripItem(int train, String source, String destination, String date, String time, String Agency)
{
    this.train=train;
    this.source=source;
    this.destination=destination;
    this.date=date;
    this.time=time;
    this.Agency=Agency;
}
    TrainTripItem(int id,String source,String destination,String date,String time,String Agency,int fare,int Total_seats,int Train_id)
    {
        this.id=id;
        this.source=source;
        this.destination=destination;
        this.date=date;
        this.time=time;
        this.Agency=Agency;
        this.fare=fare;
        this.Total_seats=Total_seats;
        this.Train_id=Train_id;
    }
    public String getSource() {
        return source;
    }

    public int getTrain() {
        return train;
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

    public int getTrain_id() {
        return Train_id;
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

    public void setTrain(int train) {
        this.train = train;
    }

}
