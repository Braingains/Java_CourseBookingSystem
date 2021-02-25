package com.codeclan.example.bookingsystem.models;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "date")
    private String date;

    public Booking(String date) {
        this.date = date;
    }



    public Booking () {}



    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
