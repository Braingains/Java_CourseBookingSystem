package com.codeclan.example.bookingsystem.controllers;

import com.codeclan.example.bookingsystem.models.Booking;
import com.codeclan.example.bookingsystem.models.Customer;
import com.codeclan.example.bookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    //GET /bookings?date=25-2-21

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity getAllBookingsByDate (

            @RequestParam(required = false, name = "date") String date
    ){
        if (date != null){

            return new ResponseEntity(bookingRepository.findAllBookingsByDate(date), HttpStatus.OK);
        }

            return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);

    }
}
