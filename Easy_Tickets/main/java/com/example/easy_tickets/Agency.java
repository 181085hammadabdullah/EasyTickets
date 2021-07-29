package com.example.easy_tickets;

import java.io.Serializable;

public class Agency implements Serializable {
    private int Id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String status;
    private String helpline;
    Agency(int Id,String name,String email,String password,String address, String status,String helpline)
    {
        this.Id=Id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.address=address;
        this.status=status;
        this.helpline=helpline;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return Id;
    }

    public String getHelpline() {
        return helpline;
    }

    public String getStatus() {
        return status;
    }
}
