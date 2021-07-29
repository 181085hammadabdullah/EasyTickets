package com.example.easy_tickets;

import java.io.Serializable;

public class TrainItem implements Serializable {
    private int train;
    private String company;
    private String model;
    private String color;
    private String registration;
    private int seats;
    private int trainid;
    private int agencyid;
    TrainItem(int train, String company, String model, String color, String registration, int seats)
    {
        this.train=train;
        this.company=company;
        this.model=model;
        this.color=color;
        this.registration=registration;
        this.seats=seats;
    }
    TrainItem(int trainid,String reg,int agencyid)
    {
        this.trainid=trainid;
        this.registration=reg;
        this.agencyid=agencyid;
    }
    public int getTrain() {
        return train;
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

    public int getTrainid() {
        return trainid;
    }
}
