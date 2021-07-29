package com.example.easy_tickets;

import java.io.Serializable;

public class AgencyProfile_ItemA implements Serializable {
    private int image;
    private String name;
    private String email;
    private String phoneno;
    private String address;
    AgencyProfile_ItemA(int image, String name, String email, String phoneno)
    {
        this.image=image;
        this.name=name;
        this.email=email;
        this.phoneno=phoneno;
    }
    AgencyProfile_ItemA(int image, String name, String email, String phoneno, String address)
    {
        this.image=image;
        this.name=name;
        this.email=email;
        this.phoneno=phoneno;
        this.address=address;
    }

    public int getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneno() {
        return phoneno;
    }


}
