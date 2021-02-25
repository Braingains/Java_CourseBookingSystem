package com.codeclan.example.bookingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JsonIgnoreProperties({"bookings"})
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;


    @ManyToOne
    @JsonIgnoreProperties({"bookings"})
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;



    public Booking(String date, Customer customer, Course course) {
        this.date = date;
        this.course = course;
        this.customer = customer;
    }



    public Booking () {}




    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
