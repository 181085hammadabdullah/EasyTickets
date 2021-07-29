package com.example.easy_tickets;

import java.io.Serializable;

public class TrainsTrip_item implements Serializable {
    private int train;
    private String source;
    private String destination;
    private String date;
    private String time;
    private String Train;
    public TrainsTrip_item(int train, String source, String destination, String date, String time, String Train)
    {
        this.train=train;
        this.source=source;
        this.destination=destination;
        this.date=date;
        this.time=time;
        this.Train=Train;
    }

    public String getSource() {
        return source;
    }

    public int getTrain() {
        return train;
    }

    public String getTrain2() {
        return Train;
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
